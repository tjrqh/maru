package project.maru.application.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryLoginCountRequest;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryLoginCountResponse;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryRequest;
import project.maru.application.dto.loginHistoryDto.GetLoginHistoryResponse;
import project.maru.application.dto.loginHistoryDto.PostLoginRequest;
import project.maru.domain.Rank;
import project.maru.domain.UserLogInLogs;
import project.maru.infrastructure.RankRepository;
import project.maru.infrastructure.UserLoginLogsRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginHistoryService {

  private final UserLoginLogsRepository userLoginLogsRepository;
  private final RankRepository rankRepository;


  public List<GetLoginHistoryResponse> findUserLoginHistory(
      GetLoginHistoryRequest getLoginHistoryRequest) {
    String userId = getLoginHistoryRequest.getUserId();
    Timestamp startDate = Timestamp.valueOf(
        getLoginHistoryRequest.getStartDate().atStartOfDay());
    Timestamp endDate = Timestamp.valueOf(
        getLoginHistoryRequest.getEndDate().atTime(LocalTime.MAX));

    List<UserLogInLogs> logs = userLoginLogsRepository.findByUserIdAndStartDateAndEndDate(userId,
        startDate, endDate);
    List<GetLoginHistoryResponse> list = logs.stream()
        .map(row -> GetLoginHistoryResponse.builder()
            .userId(row.getUserId())
            .createdAt(row.getCreatedAt().toLocalDateTime())
            .build())
        .collect(Collectors.toList());
    return list;
  }

  @Transactional
  public void insertUserLoginHistory(PostLoginRequest postLoginRequest) {
    String userId = postLoginRequest.getUserId();
    LocalDate now = LocalDate.now();
    log.info("insert user의 로그인 시간은 localdate 기준 : " + now);
    Timestamp startDate = Timestamp.valueOf(
        now.atStartOfDay());
    Timestamp endDate = Timestamp.valueOf(now.atTime(LocalTime.MAX));
    Integer results = userLoginLogsRepository.findByUserIdAndStartDateAndEndDateCount(
        userId, startDate, endDate);
    if (results == null || results == 0) {
      UserLogInLogs userLogInLogs = new UserLogInLogs(userId);
      userLoginLogsRepository.save(userLogInLogs);
    }
    UserLogInLogs userLogInLogs = new UserLogInLogs(userId);
    userLoginLogsRepository.save(userLogInLogs);
    Rank r = rankRepository.findScoreByUserId(postLoginRequest.getUserId());
    if (r == null) {
      r = Rank.builder().userId(postLoginRequest.getUserId()).name(postLoginRequest.getUser())
          .score(0).build();
    } else {
      r.setName(postLoginRequest.getUser());
    }
    rankRepository.save(r);
  }

  public List<LocalDate> findUserLoginCalendar(String userId) {
    LocalDate now = LocalDate.now().withDayOfMonth(1);
    Timestamp startDate = Timestamp.valueOf(
        now.atStartOfDay());
    Timestamp endDate = Timestamp.valueOf(
        YearMonth.from(now).atEndOfMonth().atTime(LocalTime.MAX));

    List<String> dateStrings = userLoginLogsRepository.countLoginByDay(userId, startDate, endDate);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return dateStrings.stream()
        .map(dateStr -> LocalDate.parse(dateStr, formatter))
        .collect(Collectors.toList());

  }

  public int findTodayLoginTotal() {
    LocalDate now = LocalDate.now();
    Timestamp startDate = Timestamp.valueOf(
        now.atStartOfDay());
    Timestamp endDate = Timestamp.valueOf(
        now.atTime(LocalTime.MAX));
    Integer count = userLoginLogsRepository.countLoginUsers(startDate, endDate);
    if (count == null) {
      count = 0;
    }
    return count;

  }

  public List<GetLoginHistoryLoginCountResponse> findUserLoginCount(
      GetLoginHistoryLoginCountRequest getLoginHistoryLoginCountRequest) {
    String userId = getLoginHistoryLoginCountRequest.getUserId();
    LocalDate startDay = getLoginHistoryLoginCountRequest.getStartDate();
    LocalDate endDay = getLoginHistoryLoginCountRequest.getEndDate();
    Timestamp startDate, endDate;

    if (startDay == null) {
      startDay = LocalDate.now().withDayOfMonth(1);
      endDay = YearMonth.from(startDay).atEndOfMonth();
    }
    if (endDay == null) {
      endDay = YearMonth.from(startDay).atEndOfMonth();
    }
    startDate = Timestamp.valueOf(
        startDay.atStartOfDay());
    endDate = Timestamp.valueOf(
        endDay.atTime(LocalTime.MAX));
    List<GetLoginHistoryLoginCountResponse> list = new ArrayList<>();
    List<Object[]> results;

    // 월별 로그인 횟수 조회
    results = userLoginLogsRepository.countLoginByMonth(userId, startDate, endDate);

    return results.stream()
        .map(row -> GetLoginHistoryLoginCountResponse.builder()
            .date(LocalDate.parse((CharSequence) row[0]))
            .count((Integer) row[1])
            .userId(userId).build())
        .collect(Collectors.toList());

  }

}

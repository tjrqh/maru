package project.maru.application.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryLoginCountRequest;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryLoginCountResponse;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryRequest;
import project.maru.application.dto.LoginHistoryDto.GetLoginHistoryResponse;
import project.maru.application.dto.LoginHistoryDto.PostLoginRequest;
import project.maru.domain.Rank;
import project.maru.domain.UserLogInLogs;
import project.maru.instructure.RankRepository;
import project.maru.instructure.UserLoginLogsRepository;

@Service
@RequiredArgsConstructor
public class LoginHistoryService {
  private final UserLoginLogsRepository userLoginLogsRepository;
  private final RankRepository rankRepository;


  public List<GetLoginHistoryResponse> findUserLoginHistory(GetLoginHistoryRequest getLoginHistoryRequest) {
    String userId = getLoginHistoryRequest.getUserId();
    LocalDate startDate = getLoginHistoryRequest.getStartDate();
    LocalDate endDate = getLoginHistoryRequest.getEndDate();

    List<UserLogInLogs> logs = userLoginLogsRepository.findByUserIdAndStartDateAndEndDate(userId, startDate, endDate);
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
    UserLogInLogs userLogInLogs = new UserLogInLogs(postLoginRequest.getUserId());
    userLoginLogsRepository.save(userLogInLogs);
    Rank r = rankRepository.findScoreByUserId(postLoginRequest.getUserId());
    if (r == null) {
      r = Rank.builder().userId(postLoginRequest.getUserId()).name(postLoginRequest.getName()).score(0).build();
    } else {
      r.setName(postLoginRequest.getName());
    }
    rankRepository.save(r);
  }

  public List<GetLoginHistoryLoginCountResponse> findUserLoginCount(GetLoginHistoryLoginCountRequest getLoginHistoryLoginCountRequest){
      String userId = getLoginHistoryLoginCountRequest.getUserId();
      LocalDate startDate = getLoginHistoryLoginCountRequest.getStartDate();
      LocalDate endDate = getLoginHistoryLoginCountRequest.getEndDate();
      List<GetLoginHistoryLoginCountResponse> list = new ArrayList<>();
      List<Object[]> results;
    if ("month".equals(getLoginHistoryLoginCountRequest.getType())) {
        // 월별 로그인 횟수 조회
        results = userLoginLogsRepository.countLoginByMonth(userId,startDate, endDate);
      } else {
        // 기본적으로 일별 로그인 횟수 조회
        results = userLoginLogsRepository.countLoginByDay(userId, startDate,
            endDate);
      }
      for (Object[] result : results) {
        LocalDate date = (LocalDate) result[0];
        Long count = (Long) result[1];
        list.add(
            GetLoginHistoryLoginCountResponse.builder().count(count.intValue())
                .date(date)
                .userId(userId)
                .build()
        );
      }
      return list;
  }

}

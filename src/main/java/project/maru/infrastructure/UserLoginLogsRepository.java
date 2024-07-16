package project.maru.infrastructure;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.maru.application.dto.rankDto.RankReadResponse;
import project.maru.domain.UserLogInLogs;

public interface UserLoginLogsRepository extends JpaRepository<UserLogInLogs, Long> {

  @Query("SELECT DATE_FORMAT(lh.createdAt, '%Y-%m-01') FROM UserLogInLogs lh WHERE lh.userId = :userId AND lh.createdAt BETWEEN :startDate AND :endDate GROUP BY DATE_FORMAT(lh.createdAt, '%Y-%m-01')")
  List<Object[]> countLoginByMonth(@Param("userId") String userId,
      @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

  @Query("SELECT DATE_FORMAT(lh.createdAt, '%Y-%m-%d') FROM UserLogInLogs lh WHERE lh.userId = :userId AND lh.createdAt BETWEEN :startDate AND :endDate GROUP BY DATE_FORMAT(lh.createdAt, '%Y-%m-%d') ORDER BY lh.createdAt ASC")
  List<String> countLoginByDay(@Param("userId") String userId,
      @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);


  @Query("SELECT lh FROM UserLogInLogs lh WHERE lh.userId = :userId AND lh.createdAt BETWEEN :startDate AND :endDate")
  List<UserLogInLogs> findByUserIdAndStartDateAndEndDate(
      @Param("userId") String userId,
      @Param("startDate") Timestamp startDate,
      @Param("endDate") Timestamp endDate);

  @Query(value = "select count(*) from user_login_logs where  CAST(created_at AS DATE) =  LEFT(NOW(),10)",
      nativeQuery = true)
  Integer countLoginUsers(@Param("startDate") Timestamp startDate,
      @Param("endDate") Timestamp endDate);

  @Query(value = "SELECT COUNT(lh.user_id) FROM user_login_logs lh WHERE lh.user_id = :userId AND lh.created_at BETWEEN :startDate AND :endDate ",
      nativeQuery = true)
  Integer findByUserIdAndStartDateAndEndDateCount(
      @Param("userId") String userId,
      @Param("startDate") Timestamp startDate,
      @Param("endDate") Timestamp endDate);
}

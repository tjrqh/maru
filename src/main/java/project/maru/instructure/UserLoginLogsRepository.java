package project.maru.instructure;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.maru.domain.UserLogInLogs;

public interface UserLoginLogsRepository extends JpaRepository<UserLogInLogs, Long> {

  @Query("SELECT DATE_FORMAT(lh.createdAt, '%Y-%m-01'), COUNT(lh) FROM UserLogInLogs lh WHERE lh.userId = :userId AND lh.createdAt BETWEEN :startDate AND :endDate GROUP BY DATE_FORMAT(lh.createdAt, '%Y-%m-01')")
  List<Object[]> countLoginByMonth(@Param("userId") String userId,
      @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

  @Query("SELECT DATE_FORMAT(lh.createdAt, '%Y-%m-%d'), COUNT(lh) FROM UserLogInLogs lh WHERE lh.userId = :userId AND lh.createdAt BETWEEN :startDate AND :endDate GROUP BY DATE_FORMAT(lh.createdAt, '%Y-%m-%d') ORDER BY lh.createdAt ASC")
  List<Object[]> countLoginByDay(@Param("userId") String userId,
      @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

  @Query("SELECT lh FROM UserLogInLogs lh WHERE lh.userId = :userId AND lh.createdAt BETWEEN :startDate AND :endDate")
  List<UserLogInLogs> findByUserIdAndStartDateAndEndDate(
      @Param("userId") String userId,
      @Param("startDate") Timestamp startDate,
      @Param("endDate") Timestamp endDate);


}

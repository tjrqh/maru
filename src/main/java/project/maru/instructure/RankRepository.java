package project.maru.instructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.maru.application.dto.RankDto.RankReadResponse;
import project.maru.domain.Rank;

public interface RankRepository extends JpaRepository<Rank, Long> {

  List<Rank> findByeMail(String eMail);


/*  //User의 토큰값(sub)를 받아 그 사람의 전체 Score의 누적 합 쿼리
  @Query("SELECT SUM(r.score) FROM Rank r WHERE r.eMail = :eMail")
  Long sumScoreBySub(@Param("eMail") String eMail);*/

  @Query("SELECT new project.maru.application.dto.RankDto.RankReadResponse(r.userId, r.score) FROM Rank r WHERE r.userId = :userId")
  List<RankReadResponse> findByUserId(String userId);

  @Query(value = "SELECT new project.maru.application.dto.RankDto.RankReadResponse(r.userId, r.score) FROM Rank r ORDER BY r.score DESC LIMIT :quantity")
  List<RankReadResponse> findTopSubScores(@Param("quantity") int quantity);

  @Query("SELECT new project.maru.application.dto.RankDto.RankReadResponse(r.userId, r.score) FROM Rank r WHERE r.userId IN :userIds")
  List<RankReadResponse> findBySubIn(List<String> userIds);
}
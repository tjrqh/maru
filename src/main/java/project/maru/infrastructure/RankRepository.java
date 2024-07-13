package project.maru.instructure;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.maru.application.dto.rankDto.RankReadResponse;
import project.maru.domain.Rank;

public interface RankRepository extends JpaRepository<Rank, Long> {

  //Rank의 UserId값을 찾아 Score 반환
  @Query(value = "SELECT u FROM Rank u WHERE u.userId = :userId")
  Rank findScoreByUserId(String userId);

  //  @Query(value = "SELECT new project.maru.application.dto.RankDto.RankReadResponse(r.userId, r.score) FROM Rank r WHERE r.userId = :userId")
  /*@Query(value =
      "SELECT new project.maru.application.dto.RankDto.RankReadResponse(r.userId, r.score, " +
          "(SELECT COUNT(*) + 1 FROM Rank r2 WHERE r2.score > r.score)) " +
          "FROM Rank r WHERE r.userId = :userId", nativeQuery = true)*/
//  @Query(SELECT ranking FROM(
//      SELECT id, name, score, RANK()OVER(ORDER BY score DESC)
//  as ranking
//  FROM scores
//  )
//  as ranked_scores
//  WHERE name = 'Alice')
  @Query("SELECT r FROM Rank r WHERE r.userId = :userId")
  Optional<Rank> findByUserId(@Param("userId") String userId);

  @Query(value = "SELECT ranking FROM (" +
      "    SELECT user_id, " +
      "           RANK() OVER (ORDER BY score DESC) as ranking " +
      "    FROM user_scores" +
      ") ranked " +
      "WHERE user_id = :userId", nativeQuery = true)
  Integer findRankingByUserId(@Param("userId") String userId);

  @Query(value = "SELECT new project.maru.application.dto.rankDto.RankReadResponse(r.name, r.score) FROM Rank r ORDER BY r.score DESC LIMIT :quantity")
  List<RankReadResponse> findTopSubScores(@Param("quantity") int quantity);


}
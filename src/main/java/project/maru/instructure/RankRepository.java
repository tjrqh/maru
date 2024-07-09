package project.maru.instructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.maru.application.dto.RankDto.RankReadResponse;
import project.maru.domain.Rank;

public interface RankRepository extends JpaRepository<Rank, Long> {

  //Rank의 UserId값을 찾아 Score 반환
  @Query("SELECT u FROM Rank u WHERE u.userId = :userId")
  Rank findScoreByUserId(String userId);

  @Query("SELECT new project.maru.application.dto.RankDto.RankReadResponse(r.userId, r.score) FROM Rank r WHERE r.userId = :userId")
  List<RankReadResponse> findByUserId(String userId);

  @Query(value = "SELECT new project.maru.application.dto.RankDto.RankReadResponse(r.userId, r.score) FROM Rank r ORDER BY r.score DESC LIMIT :quantity")
  List<RankReadResponse> findTopSubScores(@Param("quantity") int quantity);


}
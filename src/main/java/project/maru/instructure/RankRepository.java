package project.maru.instructure;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.maru.domain.Rank;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {

  List<Rank> findByUserId(String userId);

  //User의 토큰값(sub)를 받아 그 사람의 전체 Score의 누적 합 쿼리
  @Query("SELECT SUM(r.score) FROM Rank r WHERE r.userId = :userId")
  Long sumScoreBySub(@Param("userId") String userId);

  @Query("SELECT r FROM Rank r WHERE r.userId IN :userId")
  List<Rank> findBySubIn(@Param("userId") List<String> userId);

  @Query("SELECT r.userId, SUM(r.score) as totalScore FROM Rank r GROUP BY r.userId ORDER BY totalScore DESC")
  List<Object[]> findTopSubScores(Pageable pageable);
}
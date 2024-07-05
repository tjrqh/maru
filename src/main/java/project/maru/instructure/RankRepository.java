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

  //User의 토큰값(sub)를 받아 그 사람의 전체 Score의 누적 합 쿼리
  @Query("SELECT SUM(r.score) FROM Rank r WHERE r.sub = :sub")
  Long sumScoreBySub(@Param("sub") String sub);

  @Query("SELECT r FROM Rank r WHERE r.sub IN :subs")
  List<Rank> findBySubIn(@Param("subs") List<String> subs);

  @Query("SELECT r.sub, SUM(r.score) as totalScore FROM Rank r GROUP BY r.sub ORDER BY totalScore DESC")
  List<Object[]> findTopSubScores(Pageable pageable);
}
package project.maru.infrastructure;

import java.util.List;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.domain.QuestionsKr;

public interface QuestionsKrRepository extends JpaRepository<QuestionsKr, String> {


  //@Query("SELECT new project.maru.application.dto.questionKrDto.QuestionsKrReadResponse(q.question, q.answer,q.score,q.contentTypeId) FROM QuestionsKr q WHERE q.contentTypeId = :contentTypeId")
  //QuestionsKrReadResponse findByContentTypeId(int contentTypeId);

  @Query(value = "SELECT q.* FROM questions q " +
                 "WHERE q.content_type_id = :contentTypeId " +
                 "AND q.id NOT IN (SELECT question_id FROM selected_questions) " +
                 "ORDER BY RAND() " +
                 "LIMIT :limit",
         nativeQuery = true)
  QuestionsKrReadResponse findRandomQuestions(@Param("contentTypeId") int contentTypeId,
                                     @Param("limit") int limit);

  QuestionsKr findById(int id);


  @Query("SELECT COUNT(e) FROM QuestionsKr e WHERE e.deletedAt IS NULL")
  long countByDeletedAtIsNull();

}

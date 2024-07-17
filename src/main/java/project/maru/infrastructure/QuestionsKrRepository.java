package project.maru.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.domain.QuestionsKr;

public interface QuestionsKrRepository extends JpaRepository<QuestionsKr, String> {

  QuestionsKr findById(int id);
  @Query("SELECT new project.maru.application.dto.questionKrDto.QuestionsKrReadResponse(q.id, q.question, ql.question, q.answer) " +
         "FROM QuestionsKr q " +
         "LEFT JOIN q.questionLanguages ql " +
         "WHERE q.quotes.id = :id")
  QuestionsKrReadResponse findByQuotesId(int id);

  @Query("SELECT COUNT(e) FROM QuestionsKr e WHERE e.deletedAt IS NULL")
  long countByDeletedAtIsNull();

}

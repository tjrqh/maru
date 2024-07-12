package project.maru.instructure;

import org.springframework.data.jpa.repository.JpaRepository;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.application.dto.questionKrDto.QuestionsKrUpdateRequest;
import project.maru.domain.QuestionsKr;

public interface QuestionsKrRepository extends JpaRepository<QuestionsKr, String> {

  //@Query("SELECT new project.maru.application.dto.questionKrDto.QuestionsKrReadResponse(q.question, q.answer,q.score,q.contentTypeId) FROM QuestionsKr q WHERE q.contentTypeId = :contentTypeId")
  QuestionsKrReadResponse findByContentTypeId(int contentTypeId);

  QuestionsKrUpdateRequest findById(int questionKrId);

}

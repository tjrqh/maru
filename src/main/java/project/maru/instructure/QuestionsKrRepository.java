package project.maru.instructure;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< Updated upstream
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.application.dto.questionKrDto.QuestionsKrUpdateRequest;
=======
import org.springframework.data.jpa.repository.Query;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
>>>>>>> Stashed changes
import project.maru.domain.QuestionsKr;

public interface QuestionsKrRepository extends JpaRepository<QuestionsKr, String> {

<<<<<<< Updated upstream
  //@Query("SELECT new project.maru.application.dto.questionKrDto.QuestionsKrReadResponse(q.question, q.answer,q.score,q.contentTypeId) FROM QuestionsKr q WHERE q.contentTypeId = :contentTypeId")
  QuestionsKrReadResponse findByContentTypeId(int contentTypeId);

  QuestionsKrUpdateRequest findById(int questionKrId);
=======
  @Query("SELECT new project.maru.application.dto.questionKrDto.QuestionsKrReadResponse(q.question, q.answer,q.score,q.contentTypeId) FROM QuestionsKr q WHERE q.contentTypeId = :contentTypeId")
  QuestionsKrReadResponse findByContentTypeId(int contentTypeId);

  QuestionsKr findById(int id);
>>>>>>> Stashed changes

}

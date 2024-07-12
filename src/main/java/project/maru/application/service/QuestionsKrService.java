package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
<<<<<<< Updated upstream
import project.maru.application.dto.questionKrDto.QuestionsKrUpdateRequest;
=======
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.domain.QuestionsKr;
>>>>>>> Stashed changes
import project.maru.instructure.QuestionsKrRepository;

@Service
@RequiredArgsConstructor
public class QuestionsKrService {

  private final QuestionsKrRepository questionsKrRepository;

  public QuestionsKrReadResponse getQuestionsKrService(int contentTypeId, int n) {
    return questionsKrRepository.findByContentTypeId(contentTypeId);
  }

<<<<<<< Updated upstream
  public QuestionsKrUpdateRequest putBeenPassed(int id, int passed) {
    int totalPassed =
        passed + questionsKrRepository.findById(id).getBeenPassed();
    QuestionsKrUpdateRequest quest = questionsKrRepository.findById(id);
    quest.setBeenPassed(totalPassed);
    return quest;
=======
  public QuestionsKr putUpdatePassed(RankUpdateRequest rankUpdateRequest) {
    int totalPassed = questionsKrRepository.findById(rankUpdateRequest.getQuestionKrId())
        .getBeenPassed();
    
    System.out.println(totalPassed);
    if (rankUpdateRequest.isBeenPassed()) {
      totalPassed += 1;
    }

    System.out.println(totalPassed);
    QuestionsKr quest = questionsKrRepository.findById(rankUpdateRequest.getQuestionKrId());
    quest.setBeenPassed(totalPassed);

    return questionsKrRepository.save(quest);
>>>>>>> Stashed changes
  }

}

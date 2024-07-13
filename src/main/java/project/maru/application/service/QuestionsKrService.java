package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.domain.QuestionsKr;
import project.maru.instructure.QuestionsKrRepository;

@Service
@RequiredArgsConstructor
public class QuestionsKrService {

  private final QuestionsKrRepository questionsKrRepository;

  public QuestionsKr putUpdatePassed(RankUpdateRequest rankUpdateRequest) {
    QuestionsKr quest = questionsKrRepository.findById(rankUpdateRequest.getQuestionKrId());
    int totalPassed = quest.getBeenPassed();

    if (rankUpdateRequest.isBeenPassed()) {
      totalPassed += 1;
    }

    quest.setBeenPassed(totalPassed);

    return questionsKrRepository.save(quest);
  }

}

package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Service;
import project.maru.application.dto.questionKrDto.GetQuestionCountResponse;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.domain.QuestionsKr;
import project.maru.infrastructure.QuestionsKrRepository;

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

  public QuestionsKrReadResponse getQuestionsKrService(int contentTypeId, int n) {
    return questionsKrRepository.findByQuotesId(contentTypeId);

  }

  public GetQuestionCountResponse getQuestionTotalCount() {
    return GetQuestionCountResponse.builder()
        .QuestionTotalCounts(questionsKrRepository.countByDeletedAtIsNull()).build();
  }
}

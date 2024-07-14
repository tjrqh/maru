package project.maru.application.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.questionKrDto.GetQuestionCountResponse;
import project.maru.application.dto.questionKrDto.QuestionsKrJsonResponse;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.domain.QuestionsKr;
import project.maru.infrastructure.QuestionsKrRepository;
import project.maru.infrastructure.QuotesRepository;

@Service
@RequiredArgsConstructor
public class QuestionsKrService {

  private final QuestionsKrRepository questionsKrRepository;
  private final QuotesRepository quotesRepository;
  private QuestionsKrJsonResponse questionsKrJsonResponse;

  public QuestionsKr putUpdatePassed(RankUpdateRequest rankUpdateRequest) {
    QuestionsKr quest = questionsKrRepository.findById(rankUpdateRequest.getQuestionKrId());
    int totalPassed = quest.getBeenPassed();

    if (rankUpdateRequest.isBeenPassed()) {
      totalPassed += 1;
    }

    quest.setBeenPassed(totalPassed);

    return questionsKrRepository.save(quest);
  }


  public QuestionsKrJsonResponse getRandomQuestionsByQuotesId(int contentTypeId, int count) {
    List<Integer> shuffledList = new ArrayList<>(
        quotesRepository.findByContentTypeId(contentTypeId));
    Collections.shuffle(shuffledList);

    // 랜덤하게 n개의 값을 저장할 리스트
    List<QuestionsKrReadResponse> randomValues = new ArrayList<>();

    // 랜덤하게 섞인 리스트에서 n개의 값을 가져옴
    for (int i = 0; i < count && i < shuffledList.size(); i++) {
      randomValues.add(questionsKrRepository.findByQuotesId(shuffledList.get(i)));
    }
    questionsKrJsonResponse = new QuestionsKrJsonResponse(randomValues);
    return questionsKrJsonResponse;
}

  public GetQuestionCountResponse getQuestionTotalCount() {
    return GetQuestionCountResponse.builder()
        .QuestionTotalCounts(questionsKrRepository.countByDeletedAtIsNull()).build();
  }
}

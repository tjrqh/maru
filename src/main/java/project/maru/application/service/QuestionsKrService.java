package project.maru.application.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

  public QuestionsKr putUpdateCalled(int id) {
    QuestionsKr quest = questionsKrRepository.findById(id);
    int totalPassed = quest.getBeenCalled();
    int calledValue = 1;

    totalPassed += calledValue;
    quest.setBeenCalled(totalPassed);

    return questionsKrRepository.save(quest);
  }


  public List<QuestionsKrReadResponse> getRandomQuestionsByQuotesId(int contentTypeId, int count) {
    List<Integer> shuffledList = new ArrayList<>(
        quotesRepository.findByContentTypeId(contentTypeId));
    Collections.shuffle(shuffledList);

    // 랜덤하게 n개의 값을 저장할 리스트
    List<QuestionsKrReadResponse> randomValues = new ArrayList<>();

    // 랜덤하게 섞인 리스트에서 n개의 값을 가져옴
    for (int i = 0; i < count && i < shuffledList.size(); i++) {
      int id = shuffledList.get(i);
      QuestionsKrReadResponse quest = questionsKrRepository.findByQuotesId(id);
      putUpdateCalled(id);
      quest.setTitle(quotesRepository.findtitleById(id));
      randomValues.add(quest);
    }
    questionsKrJsonResponse = new QuestionsKrJsonResponse(randomValues);
    return questionsKrJsonResponse.getQuestions();
  }

  public long getQuestionTotalCount() {
    return questionsKrRepository.countByDeletedAtIsNull();
  }
}

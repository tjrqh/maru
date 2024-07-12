package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.application.dto.questionKrDto.QuestionsKrUpdateRequest;
import project.maru.instructure.QuestionsKrRepository;

@Service
@RequiredArgsConstructor
public class QuestionsKrService {

  private final QuestionsKrRepository questionsKrRepository;

  public QuestionsKrReadResponse getQuestionsKrService(int contentTypeId, int n) {
    return questionsKrRepository.findByContentTypeId(contentTypeId);
  }

  public QuestionsKrUpdateRequest putBeenPassed(int id, int passed) {
    int totalPassed =
        passed + questionsKrRepository.findById(id).getBeenPassed();
    QuestionsKrUpdateRequest quest = questionsKrRepository.findById(id);
    quest.setBeenPassed(totalPassed);
    return quest;
  }

}

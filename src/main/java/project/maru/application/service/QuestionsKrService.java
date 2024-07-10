package project.maru.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.QuestionKrDto.QuestionsKrReadResponse;
import project.maru.instructure.QuestionsKrRepository;

@Service
@RequiredArgsConstructor
public class QuestionsKrService {

  private final QuestionsKrRepository questionsKrRepository;

  public QuestionsKrReadResponse getQuestionsKrService(int contentTypeId) {
    return questionsKrRepository.findByContentTypeId(contentTypeId);
  }

}

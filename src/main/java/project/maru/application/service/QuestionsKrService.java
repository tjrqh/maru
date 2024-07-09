package project.maru.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.maru.application.dto.QuestionKrDto.QuestionsKrReadResponse;
import project.maru.instructure.QuestionsKrRepository;

@Service
public class QuestionsKrService {

  @Autowired
  private QuestionsKrRepository questionsKrRepository;

  public QuestionsKrReadResponse getQuestionsKrService(int contentTypeId) {
    return questionsKrRepository.findByContentTypeId(contentTypeId);
  }

}

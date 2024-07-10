package project.maru.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.QuestionKrDto.QuestionsKrReadResponse;
import project.maru.application.service.QuestionsKrService;

@RestController
@RequestMapping("/api/learning")
public class QuestionsKrController {

  @Autowired
  private QuestionsKrService questionsKrService;

  @GetMapping("/questions")
  public QuestionsKrReadResponse getQuestionsKr(@RequestParam int contentTypeId,
      @RequestParam int n) {
    return questionsKrService.getQuestionsKrService(contentTypeId);
  }
}

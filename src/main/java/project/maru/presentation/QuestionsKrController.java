package project.maru.presentation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.questionKrDto.GetQuestionCountResponse;
import project.maru.application.dto.questionKrDto.QuestionsKrJsonResponse;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.application.service.QuestionsKrService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionsKrController {

  private final QuestionsKrService questionsKrService;

  @GetMapping("/questions")
  public QuestionsKrJsonResponse getQuestionsKr(@RequestParam int contentTypeId,
      @RequestParam int n) {
    return questionsKrService.getRandomQuestionsByQuotesId(contentTypeId, n);
  }

  @GetMapping("/total-questions")
  public GetQuestionCountResponse getQuestionTotalCount() {
    return questionsKrService.getQuestionTotalCount();
  }

}

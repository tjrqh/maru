package project.maru.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.questionKrDto.QuestionsKrReadResponse;
import project.maru.application.service.QuestionsKrService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionsKrController {

  private final QuestionsKrService questionsKrService;
  @Operation(summary = "질문 목록 조회 GET")
  @GetMapping("/questions")
  public List<QuestionsKrReadResponse> getQuestionsKr(@RequestParam("contentTypeId") int contentTypeId,
      @RequestParam("n") int n) {
    return questionsKrService.getRandomQuestionsByQuotesId(contentTypeId, n);
  }

  @Operation(summary = "전체 질문 수 조회 GET")
  @GetMapping("/total-questions")
  public long getQuestionTotalCount() {
    return questionsKrService.getQuestionTotalCount();
  }

}

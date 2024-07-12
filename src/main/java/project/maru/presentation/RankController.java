package project.maru.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< Updated upstream
import project.maru.application.dto.questionKrDto.QuestionsKrUpdateRequest;
import project.maru.application.dto.rankDto.RankJsonResponse;
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.application.service.RankService;
=======
import project.maru.application.dto.rankDto.RankJsonResponse;
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.application.service.RankService;
import project.maru.domain.QuestionsKr;
>>>>>>> Stashed changes
import project.maru.presentation.util.ParseToken;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RankController {

  private final RankService rankService;
  private final ParseToken parseToken;


  @GetMapping("/rankings")
  public RankJsonResponse getScore(@RequestHeader("Authorization") String accessToken,
      @RequestParam int limit, @RequestParam boolean includeUser)
      throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    return rankService.getMyScoreAndTop20Rank(userId, limit, includeUser);
  }

  @PutMapping("/update")
<<<<<<< Updated upstream
  public QuestionsKrUpdateRequest updateScore(@RequestHeader("Authorization") String accessToken,
=======
  public QuestionsKr updateScore(@RequestHeader("Authorization") String accessToken,
>>>>>>> Stashed changes
      @RequestBody RankUpdateRequest rankUpdateRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    return rankService.updateRank(userId, rankUpdateRequest);
  }


}

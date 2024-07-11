package project.maru.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.RankDto.RankJsonResponse;
import project.maru.application.dto.RankDto.RankUpdateRequest;
import project.maru.application.service.RankService;
import project.maru.domain.Rank;
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
  public Rank updateScore(@RequestHeader("Authorization") String accessToken,
      @RequestBody RankUpdateRequest rankUpdateRequest) throws Exception {
    String userId = parseToken.getParseToken(accessToken);
    return rankService.updateRank(userId, rankUpdateRequest.getScore());
  }


}

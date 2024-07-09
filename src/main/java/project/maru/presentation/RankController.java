package project.maru.presentation;

import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.dto.RankDto.RankReadResponse;
import project.maru.application.service.RankService;
import project.maru.presentation.util.CognitoJWTParser;

@RestController
@RequestMapping("/api")
public class RankController {

  @Autowired
  private RankService rankService;

  @Autowired
  private CognitoJWTParser cognitoJWTParser;

  @GetMapping("/rankings")
  public List<RankReadResponse> getScore(@RequestHeader("Authorization") String accessToken,
      @RequestParam int limit, @RequestParam boolean includeUser)
      throws Exception {
    DecodedJWT cognitoToken = cognitoJWTParser.parseToken(accessToken);
    String sub = cognitoToken.getClaims().get("sub").toString();
    String userId = sub.replaceAll("^\"|\"$", ""); // 앞뒤 큰따옴표 제거
    return rankService.getMyScoreAndTop20Rank(userId, limit, includeUser);
  }

  /*@PutMapping("/update")
  public ResponseEntity<Void> updateScore(@RequestParam RankUpdateRequest rankUpdateRequest) {
    rankService.
    return new ResponseEntity<>(HttpStatus.OK);
  }*/


}

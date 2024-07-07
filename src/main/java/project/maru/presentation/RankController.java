package project.maru.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.maru.application.service.RankService;
import project.maru.domain.Rank;

@RestController
@RequestMapping("/rank")
public class RankController {

  @Autowired
  private RankService rankService;

  @GetMapping("/get")
  public List<Object> getSroce(@RequestParam(value = "userId", required = true) String userId) {
    return rankService.getMyScoreAndTop20Rank(userId);
  }

  @GetMapping("/top20")
  public ResponseEntity<List<Rank>> getTop20SubScoresWithDetails() {
    List<Rank> ranks = rankService.getTop20SubScoresWithDetails();
    return ResponseEntity.ok(ranks);
  }
}

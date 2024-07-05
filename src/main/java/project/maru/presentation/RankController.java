package project.maru.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.maru.application.service.RankService;
import project.maru.domain.Rank;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private RankService rankService;


    @GetMapping("/get")
    public Long getSroce(@RequestParam(value = "sub") String sub) {
        return rankService.findTotalScoreByUserId(sub);
    }

    @GetMapping("/top20")
    public ResponseEntity<List<Rank>> getTop20SubScoresWithDetails() {
        List<Rank> ranks = rankService.getTop20SubScoresWithDetails();
        return ResponseEntity.ok(ranks);
    }
}

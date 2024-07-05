package project.maru.application.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.maru.domain.Rank;
import project.maru.instructure.RankRepository;

@Service
public class RankService {

  @Autowired
  private RankRepository rankRepository;

  public Long findTotalScoreByUserId(String sub) {
    //rankRepository.sumScoreBySub(sub);
    return rankRepository.sumScoreBySub(sub);
  }

  public List<Rank> getTop20SubScoresWithDetails() {
    Pageable pageable = PageRequest.of(0, 20);
    List<Object[]> topSubScores = rankRepository.findTopSubScores(pageable);
    // Extract sub values from the result
    List<String> topSubs = topSubScores.stream()
        .map(result -> (String) result[0])
        .collect(Collectors.toList());
    // Retrieve detailed information for these subs
    return rankRepository.findBySubIn(topSubs);
  }
    /*public RankReadResponse getRankDetails(String sub){
        Long myTotalScore =
    }*/
}
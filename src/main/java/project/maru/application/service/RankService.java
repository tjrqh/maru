package project.maru.application.service;

import java.util.ArrayList;
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

  public List<Rank> findTotalScoreByUserId(String userId) {
    //rankRepository.sumScoreByuserId(userId);
    return rankRepository.findByUserId(userId);
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

  public List<Object> getMyScoreAndTop20Rank(String userId) {
    if (findTotalScoreByUserId(userId).isEmpty()) {
      throw new IllegalStateException("조회할 수 없는 아이디 입니다.");
    } else {
      List<Object> list = new ArrayList<>();
      list.add(findTotalScoreByUserId(userId));
      list.add(getTop20SubScoresWithDetails());
      return list;
    }
  }
}
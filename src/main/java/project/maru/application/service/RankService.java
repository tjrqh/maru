package project.maru.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.maru.application.dto.RankDto.RankReadResponse;
import project.maru.instructure.RankRepository;

@Service
public class RankService {

  @Autowired
  private RankRepository rankRepository;

  public List<RankReadResponse> findTotalScoreByUserId(String userId) {
    return rankRepository.findByUserId(userId);
  }

  public List<RankReadResponse> getTop20SubScoresWithDetails() {
    Pageable pageable = PageRequest.of(0, 20);
    List<RankReadResponse> topSubScores = rankRepository.findTopSubScores(pageable);
    List<String> topSubs = topSubScores.stream()
        .map(RankReadResponse::getUserId)
        .collect(Collectors.toList());
    return rankRepository.findBySubIn(topSubs);
  }

  public List<RankReadResponse> getMyScoreAndTop20Rank(String userId) {
    List<RankReadResponse> userScores = findTotalScoreByUserId(userId);
    if (userScores.isEmpty()) {
      throw new IllegalStateException("조회할 수 없는 아이디 입니다.");
    } else {
      List<RankReadResponse> result = new ArrayList<>(userScores);
      result.addAll(getTop20SubScoresWithDetails());
      return result;
    }
  }

  /*public ResponseEntity<Void> updateUserScore(RankUpdateRequest rankUpdateRequest){
    rankRepository.
  }*/
}
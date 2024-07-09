package project.maru.application.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.RankDto.RankReadResponse;
import project.maru.instructure.RankRepository;

@Service
@RequiredArgsConstructor
public class RankService {

  private final RankRepository rankRepository;

  public List<RankReadResponse> findTotalScoreByUserId(String userId) {
    return rankRepository.findByUserId(userId);
  }

  public List<RankReadResponse> getTop20SubScoresWithDetails(int quantity) {
    return rankRepository.findTopSubScores(quantity);

  }

  public List<RankReadResponse> getMyScoreAndTop20Rank(String userId, int limit,
      boolean includeUser) {
    List<RankReadResponse> result = new ArrayList<>(getTop20SubScoresWithDetails(limit));
    if (includeUser) {
      result.addAll(findTotalScoreByUserId(userId));
    }
    return result;
  }


  /*public ResponseEntity<Void> updateUserScore(RankUpdateRequest rankUpdateRequest){
    rankRepository.
  }*/
}
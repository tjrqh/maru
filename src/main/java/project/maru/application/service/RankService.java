package project.maru.application.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.RankDto.RankReadResponse;
import project.maru.application.dto.RankDto.RankUpdateRequest;
import project.maru.domain.Rank;
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

  public Rank updateRank(String accessToken, int score) {
    int totalScore = rankRepository.findScoreByUserId(accessToken).getScore() + score;
    System.out.println(totalScore);
    RankUpdateRequest rankUpdateRequest = new RankUpdateRequest();
    rankUpdateRequest.setUserId(accessToken);
    rankUpdateRequest.setScore(totalScore);
    Rank r = rankRepository.findScoreByUserId(rankUpdateRequest.getUserId());
    r.setScore(rankUpdateRequest.getScore());
    return rankRepository.save(r);
  }

}
package project.maru.application.service;

import java.util.List;
import java.util.Optional;
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

  public RankReadResponse findTotalScoreByUserId(String userId) {
    Optional<Rank> rankOptional = rankRepository.findByUserId(userId);
    Integer ranking = rankRepository.findRankingByUserId(userId);
    if (rankOptional.isEmpty()) {
      return null;
    }
    Rank rank = rankOptional.get();
    return new RankReadResponse(rank.getUserId(), rank.getScore(), ranking != null ? ranking : 0);
  }

  public List<RankReadResponse> getTop20SubScoresWithDetails(int quantity) {
    return rankRepository.findTopSubScores(quantity);
  }

  public List<RankReadResponse> getMyScoreAndTop20Rank(String userId, int limit,
      boolean includeUser) {
    List<RankReadResponse> top20SubScoresWithDetails = getTop20SubScoresWithDetails(limit);
    for (int i = 0; i < top20SubScoresWithDetails.size(); i++) {
      RankReadResponse ith = top20SubScoresWithDetails.get(i);
      ith.setRank(i + 1);
    }
    if (includeUser) {
      top20SubScoresWithDetails.add(findTotalScoreByUserId(userId));
    }
    return top20SubScoresWithDetails;
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
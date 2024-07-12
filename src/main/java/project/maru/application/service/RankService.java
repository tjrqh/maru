package project.maru.application.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.maru.application.dto.questionKrDto.QuestionsKrUpdateRequest;
import project.maru.application.dto.rankDto.RankJsonResponse;
import project.maru.application.dto.rankDto.RankReadResponse;
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.domain.Rank;
import project.maru.instructure.RankRepository;


@Service
@RequiredArgsConstructor
public class RankService {

  private final RankRepository rankRepository;
  private final QuestionsKrService questionsKrService;
  private RankJsonResponse rankJsonResponse;


  public RankReadResponse findTotalScoreByUserId(String userId) {
    Optional<Rank> rankOptional = rankRepository.findByUserId(userId);
    Integer ranking = rankRepository.findRankingByUserId(userId);
    if (rankOptional.isEmpty()) {
      return null;
    }
    Rank rank = rankOptional.get();
    System.out.println(rank.getName());
    System.out.println(rank.getScore());
    return new RankReadResponse(rank.getName(), rank.getScore(), ranking != null ? ranking : 0);
  }

  public List<RankReadResponse> getTopRankLimitByScore(int quantity) {
    return rankRepository.findTopSubScores(quantity);
  }

  public RankJsonResponse getMyScoreAndTop20Rank(String userId, int limit,
      boolean includeUser) {

    List<RankReadResponse> topRankLimitByScore = getTopRankLimitByScore(limit);
    for (int i = 0; i < topRankLimitByScore.size(); i++) {
      RankReadResponse ith = topRankLimitByScore.get(i);
      ith.setRank(i + 1);
    }
    System.out.println(findTotalScoreByUserId(userId));
    if (includeUser) {
      rankJsonResponse = new RankJsonResponse(topRankLimitByScore,
          findTotalScoreByUserId(userId));
    } else {
      rankJsonResponse = new RankJsonResponse(topRankLimitByScore);
    }
    return rankJsonResponse;
  }

  public QuestionsKrUpdateRequest updateRank(String accessToken,
      RankUpdateRequest rankUpdateRequest) {
    int totalScore =
        rankRepository.findScoreByUserId(accessToken).getScore() + rankUpdateRequest.getScore();
    Rank r = rankRepository.findScoreByUserId(accessToken);
    r.setScore(totalScore);

    int passed = rankUpdateRequest.getBeenCalled();
    int questId = rankUpdateRequest.getQuestionKrId();
    questionsKrService.putBeenPassed(questId, passed);

    return questionsKrService.putBeenPassed(questId, passed);

  }

}
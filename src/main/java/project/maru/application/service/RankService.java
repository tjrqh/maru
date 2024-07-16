package project.maru.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import java.util.Optional;
import jdk.jshell.Snippet.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.maru.application.dto.rankDto.RankJsonResponse;
import project.maru.application.dto.rankDto.RankReadResponse;
import project.maru.application.dto.rankDto.RankUpdateRequest;
import project.maru.application.dto.voiceRecordsDto.VoiceRecordsCreateRequest;
import project.maru.domain.QuestionsKr;
import project.maru.domain.Rank;
import project.maru.domain.VoiceRecords;
import project.maru.infrastructure.QuestionsKrRepository;
import project.maru.infrastructure.RankRepository;
import project.maru.infrastructure.VoiceRecordsRepository;


@Service
@RequiredArgsConstructor
public class RankService {

  private final RankRepository rankRepository;
  private final QuestionsKrService questionsKrService;
  private final VoiceRecordsService voiceRecordsService;
  private RankJsonResponse rankJsonResponse;


  public RankReadResponse findTotalScoreByUserId(String userId) {
    Optional<Rank> rankOptional = rankRepository.findByUserId(userId);
    Integer ranking = rankRepository.findRankingByUserId(userId);
    if (rankOptional.isEmpty()) {
      return null;
    }
    Rank rank = rankOptional.get();
    return new RankReadResponse(rank.getName(), rank.getScore(), ranking != null ? ranking : 0);
  }

  public List<RankReadResponse> getTopRankLimitByScore(int quantity) {
    return rankRepository.findTopSubScores(quantity);
  }

  //랭킹 전체 조회(내 점수 포함/미포함 지정)
  public RankJsonResponse getMyScoreAndTop20Rank(String userId, int limit,
      boolean includeUser) {

    List<RankReadResponse> topRankLimitByScore = getTopRankLimitByScore(limit);
    for (int i = 0; i < topRankLimitByScore.size(); i++) {
      RankReadResponse ith = topRankLimitByScore.get(i);
      ith.setRank(i + 1);
    }
    if (includeUser) {
      rankJsonResponse = new RankJsonResponse(topRankLimitByScore,
          findTotalScoreByUserId(userId));
    } else {
      rankJsonResponse = new RankJsonResponse(topRankLimitByScore);
    }
    return rankJsonResponse;
  }


  //Issue : 음성에 대한 정답 시 음성 저장과 점수 데이터를 같이 주는지?
  public ObjectNode updateRank(String accessToken, RankUpdateRequest rankUpdateRequest) {
    ObjectMapper mapper = new ObjectMapper();
    ObjectNode jsonResponse = mapper.createObjectNode();

    try {
    if (rankUpdateRequest.isBeenPassed()) {
      Rank r = rankRepository.findScoreByUserId(accessToken);
      int addScore = 100;
      int totalScore = addScore + r.getScore();

      r.setScore(totalScore);
      rankRepository.save(r);

      questionsKrService.putUpdatePassed(rankUpdateRequest);
      voiceRecordsService.voiceRecordsLinkCreate(accessToken, rankUpdateRequest);
    }
      jsonResponse.put("message", "Answer result updated successfully");
      return jsonResponse;
    }
    catch (Exception e ){
      jsonResponse.put("message", "Error updating answer result: " + e.getMessage());
      return jsonResponse;

    }
  }
}
package project.maru.application.dto.RankDto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RankJsonResponse {

  private List<RankReadResponse> rankings;
  private RankReadResponse userRanking;

  public RankJsonResponse(List<RankReadResponse> rankings) {
    this.rankings = rankings;
  }
}


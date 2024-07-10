package project.maru.application.dto.RankDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RankReadResponse {

  private String userId;
  private int score;
  private int rank;

  public RankReadResponse(String userId, int score) {
    this.userId = userId;
    this.score = score;
  }

}

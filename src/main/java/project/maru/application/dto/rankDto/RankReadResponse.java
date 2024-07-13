package project.maru.application.dto.rankDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RankReadResponse {

  private String name;
  private int score;
  private int rank;

  public RankReadResponse(String name, int score) {
    this.name = name;
    this.score = score;
  }
}

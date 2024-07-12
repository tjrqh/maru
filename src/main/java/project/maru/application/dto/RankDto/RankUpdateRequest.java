package project.maru.application.dto.RankDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString

public class RankUpdateRequest {

  private int id;
  @Schema(hidden = true)
  private String userId;
  private int score;
  private String name;

  public RankUpdateRequest(int score) {
    this.score = score;
  }
}

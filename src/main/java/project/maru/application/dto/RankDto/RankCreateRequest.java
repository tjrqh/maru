package project.maru.application.dto.RankDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RankCreateRequest {
  @Schema(hidden = true)
  private String userId;
  private int score;

}

package project.maru.application.dto.rankDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RankCreateRequest {

  @JsonProperty("user_id")
  private String userId;
  private int score;

}

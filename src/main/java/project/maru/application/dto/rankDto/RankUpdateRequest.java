package project.maru.application.dto.rankDto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

<<<<<<< Updated upstream
=======
  private int score;

  @JsonProperty("question_kr_id")
  private int questionKrId;

  @JsonProperty("been_passed")
  private boolean beenPassed;
>>>>>>> Stashed changes

  private int score;
  private int questionKrId;
  private int beenCalled;

}

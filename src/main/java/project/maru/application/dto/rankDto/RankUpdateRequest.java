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


  @JsonProperty("questionId")
  private int questionKrId;

  @JsonProperty("isCorrect")
  private boolean beenPassed;
  @JsonProperty("userVoice")
  private String voiceRecords;
  private String userName;

}

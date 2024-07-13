package project.maru.application.dto.voiceRecordsDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import project.maru.domain.QuestionsKr;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class VoiceRecordsCreateRequest {

  private String userId;

  @JsonProperty("questions_id")
  private int questionsKrId;

  @JsonProperty("speech_to_text")
  private String speechToText;

  @JsonProperty("matching_rate")
  private int matchingRate;

}

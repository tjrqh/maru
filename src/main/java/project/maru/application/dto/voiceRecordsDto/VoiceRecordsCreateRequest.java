package project.maru.application.dto.voiceRecordsDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  @JsonProperty("voice_records")
  private String voiceRecords;

  @JsonProperty("matching_rate")
  private int matchingRate;

  public VoiceRecordsCreateRequest(String userId, int questionsKrId, String voiceRecords) {
    this.userId = userId;
    this.questionsKrId = questionsKrId;
    this.voiceRecords = voiceRecords;
  }
}

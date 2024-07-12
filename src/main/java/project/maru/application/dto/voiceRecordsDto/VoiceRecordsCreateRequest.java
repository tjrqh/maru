package project.maru.application.dto.voiceRecordsDto;

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
public class VoiceRecordsCreateRequest {

  private String userId;
  private int questionsKrId;
  private String speechToText;
  private int matchingRate;

}

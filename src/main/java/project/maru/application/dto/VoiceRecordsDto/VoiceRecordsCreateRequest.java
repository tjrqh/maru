package project.maru.application.dto.VoiceRecordsDto;

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
  private int questionsKrId;
  private String speechToText;
  private int matchingRate;
}

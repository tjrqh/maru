package project.maru.application.dto.questionKrDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class QuestionsKrUpdateRequest {

  private int questionKrId;
  private boolean beenPassed;

}

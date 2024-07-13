package project.maru.application.dto.questionKrDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class QuestionsKrReadResponse {

  private String question;
  private String answer;
  private int score;
  private int contentTypeId;

}

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

  private int id;
  private int contentTypeId;
  private String question;
  private String quest_lang;
  private String answer;


}

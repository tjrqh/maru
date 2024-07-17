package project.maru.application.dto.questionKrDto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  @JsonProperty("korean")
  private String question;
  @JsonProperty("english")
  private String questLang;
  private String answer;
  private String title;

  public QuestionsKrReadResponse(int id, String question, String questLang, String answer) {
    this.id = id;
    this.question = question;
    this.questLang = questLang;
    this.answer = answer;
  }
}

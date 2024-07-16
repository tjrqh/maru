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
}

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
  @JsonProperty("quotes_id")
  private int quotesId;
  private String question;
  @JsonProperty("quest_lang")
  private String questLang;
  private String answer;
}

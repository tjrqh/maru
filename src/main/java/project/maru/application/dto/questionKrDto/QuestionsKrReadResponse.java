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
  private String question;
  private String answer;
  private int score;
  @JsonProperty("content_type_id")
  private int contentTypeId;

}

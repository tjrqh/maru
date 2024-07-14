package project.maru.application.dto.questionKrDto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class QuestionsKrJsonResponse {

  private List<QuestionsKrReadResponse> questions;

}

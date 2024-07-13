package project.maru.application.dto.questionKrDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class GetQuestionCountResponse {

  private long QuestionTotalCounts;
}

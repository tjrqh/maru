package project.maru.application.dto.questionKrDto;

<<<<<<< Updated upstream:src/main/java/project/maru/application/dto/questionKrDto/QuestionsKrUpdateRequest.java
=======
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> Stashed changes:src/main/java/project/maru/application/dto/QuestionKrDto/QuestionsKrUpdateRequest.java
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class QuestionsKrUpdateRequest {

<<<<<<< Updated upstream:src/main/java/project/maru/application/dto/questionKrDto/QuestionsKrUpdateRequest.java
  private int beenPassed;

=======
  @JsonProperty("been_passed")
  private boolean beenPassed;
>>>>>>> Stashed changes:src/main/java/project/maru/application/dto/QuestionKrDto/QuestionsKrUpdateRequest.java
}

package project.maru.application.dto.rankDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString

public class RankUpdateRequest {


  private int score;
  private int questionKrId;
  private int beenCalled;

}

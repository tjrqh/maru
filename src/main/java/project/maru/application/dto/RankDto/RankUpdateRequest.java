package project.maru.application.dto.RankDto;

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

  private int id;
  private String userId;
  private int score;
  private String name;

}

package project.maru.application.dto.loginHistoryDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostLoginRequest {

  private String name;
  private String userId;
}

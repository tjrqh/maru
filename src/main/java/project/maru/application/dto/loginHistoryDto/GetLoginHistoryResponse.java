package project.maru.application.dto.loginHistoryDto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class GetLoginHistoryResponse {

  private String userId;
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private LocalDateTime createdAt;
}

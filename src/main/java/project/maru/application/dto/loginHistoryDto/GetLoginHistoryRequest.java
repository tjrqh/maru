package project.maru.application.dto.LoginHistoryDto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GetLoginHistoryRequest {
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate endDate;

  private String type;
  private String userId;

  public GetLoginHistoryRequest(String userId, LocalDate startDate, LocalDate endDate) {
  }
}

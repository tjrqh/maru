package project.maru.application.dto.loginHistoryDto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GetLoginHistoryCalendarResponse {

  private String userId;
  @DateTimeFormat(iso = ISO.DATE)
  private LocalDate date;
}

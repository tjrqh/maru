package project.maru.application.dto.LoginHistoryDto;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class GetLoginHistoryLoginCountRequest {
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate endDate;

  private String type;
}

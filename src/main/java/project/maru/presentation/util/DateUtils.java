package project.maru.presentation.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateUtils {

  private static final ZoneId KST_ZONE_ID = ZoneId.of("Asia/Seoul");

  public static Timestamp toKstTimestampStartOfDay(LocalDate date) {
    LocalDateTime startOfDay = date.atStartOfDay();
    ZonedDateTime kstStartDateTime = startOfDay.atZone(KST_ZONE_ID);
    return Timestamp.from(kstStartDateTime.toInstant());
  }

  public static Timestamp toKstTimestampEndOfDay(LocalDate date) {
    LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
    ZonedDateTime kstEndDateTime = endOfDay.atZone(KST_ZONE_ID);
    return Timestamp.from(kstEndDateTime.toInstant());
  }

  public static Timestamp toKstTimestampStartOfMonth(LocalDate date) {
    LocalDate startOfMonth = date.withDayOfMonth(1);
    return toKstTimestampStartOfDay(startOfMonth);
  }

  public static Timestamp toKstTimestampEndOfMonth(LocalDate date) {
    LocalDate endOfMonth = YearMonth.from(date).atEndOfMonth();
    return toKstTimestampEndOfDay(endOfMonth);
  }

  public static Timestamp toKstTimestamp(LocalDate date) {
    LocalDateTime localDateTime = date.atStartOfDay(); // LocalDate의 시작 시간
    ZonedDateTime kstZonedDateTime = localDateTime.atZone(KST_ZONE_ID); // KST로 변환
    return Timestamp.from(kstZonedDateTime.toInstant()); // Timestamp로 변환
  }
}

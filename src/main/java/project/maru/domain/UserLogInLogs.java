package project.maru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_login_logs")
@Getter
@Setter
@NoArgsConstructor

public class UserLogInLogs {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String userId;


  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp createdAt;

  public UserLogInLogs(String userId) {
    this.userId = userId;
  }

  @PrePersist
  protected void onCreate() {
    createdAt = Timestamp.valueOf(LocalDateTime.now());
  }
}

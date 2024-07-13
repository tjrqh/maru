package project.maru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user_voice_records")
@Getter
@Setter
@NoArgsConstructor
public class VoiceRecords {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "user_id", unique = true)
  private String userId;
  @Column(name = "question_kr_id")
  private int questionKrId;
  @Column(name = "speech_to_text")
  private String speechToText;
  @Column(name = "matching_rate")
  private int matchingRate;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  private LocalDateTime deletedAt;

  @PreRemove
  private void deleteLogical() {
    // 삭제 시간 설정
    this.deletedAt = LocalDateTime.now();
  }

  public VoiceRecords(String userId, int questionKrId, String speechToText, int matchingRate) {
    this.userId = userId;
    this.questionKrId = questionKrId;
    this.speechToText = speechToText;
    this.matchingRate = matchingRate;
  }
}

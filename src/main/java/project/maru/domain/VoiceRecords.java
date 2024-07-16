package project.maru.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
  @Column(name = "user_id")
  private String userId;

  @ManyToOne
  @JoinColumn(name = "questions_kr_id")
  @JsonIgnore
  private QuestionsKr questionsKr;

  @Column(name = "voice_records")
  private String recordsVoice;

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

  public VoiceRecords(String userId, QuestionsKr questionsKr, String recordsVoice,
      String speechToText, int matchingRate) {
    this.userId = userId;
    this.questionsKr = questionsKr;
    this.recordsVoice = recordsVoice;
    this.speechToText = speechToText;
    this.matchingRate = matchingRate;
  }

  public VoiceRecords(String userId, QuestionsKr questionsKr, String speechToText,
      int matchingRate) {
    this.userId = userId;
    this.questionsKr = questionsKr;
    this.speechToText = speechToText;
    this.matchingRate = matchingRate;
  }
}

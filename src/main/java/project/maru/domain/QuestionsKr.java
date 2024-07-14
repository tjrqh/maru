package project.maru.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "questions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsKr {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String question;
  private String answer;
  private int score;
  @Column(name = "been_called")
  private int beenCalled;
  @Column(name = "been_passed")
  private int beenPassed;
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  @ManyToOne
  @JoinColumn(name = "quotes_id")
  @JsonIgnore
  private Quotes quotes;


  @OneToMany(mappedBy = "questionsKr")
  private List<QuestionLanguage> questionLanguages;

  @OneToMany(mappedBy = "questionsKr")
  private List<VoiceRecords> voiceRecords;


  @PreRemove
  private void deleteLogical() {
    // 삭제 시간 설정
    this.deletedAt = LocalDateTime.now();
  }

  public QuestionsKr(String question, String answer, int score, Quotes quotes) {
    this.question = question;
    this.answer = answer;
    this.score = score;
    this.quotes = quotes;
  }

  public QuestionsKr(List<VoiceRecords> voiceRecords) {
    this.voiceRecords = voiceRecords;
  }


}

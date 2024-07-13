package project.maru.domain;

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
@Table(name = "question_lang")
@Getter
@Setter
@NoArgsConstructor
public class QuestionLanguage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String question;
  private String answer;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  @ManyToOne
  @JoinColumn(name = "languages_id")
  private Languages languages;

  @ManyToOne
  @JoinColumn(name = "question_kr_id")
  private QuestionsKr questionsKr;

  @PreRemove
  private void deleteLogical() {
    // 삭제 시간 설정
    this.deletedAt = LocalDateTime.now();
  }

}

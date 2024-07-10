package project.maru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user_scores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rank {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String userId;
  private int score;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;


  public Rank(String userId, int score) {
    this.userId = userId;
    this.score = score;
  }

  public Rank(Long id, String name, String userId, int score) {
    this.id = id;
    this.name = name;
    this.userId = userId;
    this.score = score;
  }

  public Rank(Long id, String userId, int score, String name) {
  }
}

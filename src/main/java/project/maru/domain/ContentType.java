package project.maru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "contentType")
@Getter
@Setter
@NoArgsConstructor
public class ContentType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String description;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;
}

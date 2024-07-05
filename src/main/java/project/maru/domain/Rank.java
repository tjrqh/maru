package project.maru.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;

@Entity
@Table(name ="collect_answer")
@Getter
@Setter
@NoArgsConstructor
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sub;
    private int score;
    private Long questionId;
    private DateTimeException localDate;
}

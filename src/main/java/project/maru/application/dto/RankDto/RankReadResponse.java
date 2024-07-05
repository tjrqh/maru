package project.maru.application.dto.RankDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class RankReadResponse {

    private String sub;
    private Long gameScore;

}

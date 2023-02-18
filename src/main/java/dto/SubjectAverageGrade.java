package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import model.Subject;

@Getter
@AllArgsConstructor
@ToString
public class SubjectAverageGrade {
    private Subject subject;
    private Double averageGrade;
}
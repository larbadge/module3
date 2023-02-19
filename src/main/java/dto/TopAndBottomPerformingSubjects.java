package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.Subject;

@Getter
@Setter
@Builder
public class TopAndBottomPerformingSubjects {

    private final Subject topSubject;
    private final Double topSubjectAverageGrade;
    private final Subject bottomSubject;
    private final Double bottomSubjectAverageGrade;

    @Override
    public String toString() {
        return String.format("Subject with the best academic performance- %s, average grade = %.1f%" +
                        "nAnd with the worst- %s, average grade = %.1f",
                getTopSubject(), getTopSubjectAverageGrade(),
                getBottomSubject(), getBottomSubjectAverageGrade()
        );
    }
}

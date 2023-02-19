package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Student;

@Getter
@AllArgsConstructor
public class StudentAverageGrade {

    private Student student;
    private double grade;

    @Override
    public String toString() {
        return String.format("%s %s from %s group, average grade = %.1f",
                getStudent().getFirstName(), getStudent().getLastName(),
                getStudent().getGroup().getName(), getGrade()
        );
    }
}

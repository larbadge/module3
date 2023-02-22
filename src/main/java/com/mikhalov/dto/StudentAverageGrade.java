package com.mikhalov.dto;

import com.mikhalov.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

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

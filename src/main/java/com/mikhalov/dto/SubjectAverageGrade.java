package com.mikhalov.dto;

import com.mikhalov.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class SubjectAverageGrade {
    private Subject subject;
    private Double averageGrade;
}
package com.mikhalov.repository;

import com.mikhalov.dto.StudentAverageGrade;
import com.mikhalov.model.Student;

import java.util.List;

public interface StudentRepository {

    void save(Student student);

    List<StudentAverageGrade> getAllByAverageGradeGreaterThan(double grade);

}

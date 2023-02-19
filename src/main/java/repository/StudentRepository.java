package repository;

import dto.StudentAverageGrade;

import java.util.List;

public interface StudentRepository {

    List<StudentAverageGrade> getAllByAverageGradeGreaterThan(double grade);

}

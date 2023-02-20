package repository;

import dto.StudentAverageGrade;
import model.Student;

import java.util.List;

public interface StudentRepository {

    void save(Student student);

    List<StudentAverageGrade> getAllByAverageGradeGreaterThan(double grade);

}

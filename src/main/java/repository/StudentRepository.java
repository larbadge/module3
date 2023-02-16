package repository;

import dto.StudentsCountByGroupDTO;
import model.Student;

import java.util.List;

public interface StudentRepository extends Repository<Student> {

    List<StudentsCountByGroupDTO> countByGroup();
}

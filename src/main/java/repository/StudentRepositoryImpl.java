package repository;

import dto.StudentsCountByGroupDTO;
import model.Student;

import java.util.List;

import static jpa.JpaUtil.getEntityManager;

public class StudentRepositoryImpl extends JpaRepository<Student> implements StudentRepository {

    public StudentRepositoryImpl() {
        super(Student.class);
    }

    @Override
    public List<StudentsCountByGroupDTO> countByGroup() {

        String jpql = "SELECT NEW " + StudentsCountByGroupDTO.class.getName() + "(g.name, COUNT(s)) " +
                "FROM Group g " +
                "JOIN g.students s " +
                "GROUP BY g.name";
        return getEntityManager().createQuery(jpql, StudentsCountByGroupDTO.class)
                .getResultList();
    }

    public static void main(String[] args) {


    }

}

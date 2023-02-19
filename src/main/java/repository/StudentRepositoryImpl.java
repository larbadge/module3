package repository;

import dto.StudentAverageGrade;
import model.Student;
import model.Student_;
import model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

import static util.JpaUtil.getEntityManager;

class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<StudentAverageGrade> getAllByAverageGradeGreaterThan(double grade) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StudentAverageGrade> query = cb.createQuery(StudentAverageGrade.class);
        Root<Student> root = query.from(Student.class);

        Subquery<Double> subQuery = query.subquery(Double.class);
        Root<Student> subRoot = subQuery.from(Student.class);
        MapJoin<Student, Subject, Double> gradesMapJoin = subRoot.join(Student_.grades);
        subQuery.select(cb.avg(gradesMapJoin.value()))
                .where(cb.equal(subRoot, root));

        query.select(cb.construct(StudentAverageGrade.class, root, subQuery))
                .where(cb.greaterThan(subQuery, grade));

        return em.createQuery(query).getResultList();
    }

}


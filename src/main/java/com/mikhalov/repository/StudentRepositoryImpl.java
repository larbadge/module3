package com.mikhalov.repository;

import com.mikhalov.dto.StudentAverageGrade;
import com.mikhalov.model.Student;
import com.mikhalov.model.Subject;
import com.mikhalov.model.Student_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

import static com.mikhalov.util.JpaUtil.doWithinTransaction;
import static com.mikhalov.util.JpaUtil.getEntityManager;

class StudentRepositoryImpl implements StudentRepository {

    @Override
    public void save(Student student) {
        doWithinTransaction(em -> em.persist(student));
    }

    @Override
    public List<StudentAverageGrade> getAllByAverageGradeGreaterThan(double grade) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StudentAverageGrade> query = cb.createQuery(StudentAverageGrade.class);
        Root<Student> root = query.from(Student.class);

        Subquery<Double> subQuery = query.subquery(Double.class);
        Root<Student> subRoot = subQuery.from(Student.class);
        MapJoin<Student, Subject, Integer> gradesMapJoin = subRoot.join(Student_.grades);
        subQuery.select(cb.avg(gradesMapJoin.value()))
                .where(cb.equal(subRoot, root));

        query.select(cb.construct(StudentAverageGrade.class, root, subQuery))
                .where(cb.greaterThan(subQuery, grade));

        return em.createQuery(query).getResultList();
    }

}


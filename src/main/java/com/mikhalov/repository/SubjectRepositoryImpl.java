package com.mikhalov.repository;

import com.mikhalov.dto.SubjectAverageGrade;
import com.mikhalov.dto.TopAndBottomPerformingSubjects;
import com.mikhalov.model.Student;
import com.mikhalov.model.Subject;
import com.mikhalov.model.Student_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

import static com.mikhalov.util.JpaUtil.getEntityManager;

class SubjectRepositoryImpl implements SubjectRepository {

    @Override
    public List<Subject> getRandomSubjects(int count) {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT s FROM Subject s ORDER BY RAND()", Subject.class)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public TopAndBottomPerformingSubjects getTopAndBottomPerformingSubjects() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SubjectAverageGrade> query = cb.createQuery(SubjectAverageGrade.class);
        Root<Student> root = query.from(Student.class);
        MapJoin<Student, Subject, Integer> grades = root.join(Student_.grades);

        Expression<Double> avgGrade = cb.avg(grades.value());
        query.multiselect(grades.key(), avgGrade)
                .groupBy(grades.key())
                .orderBy(cb.asc(avgGrade));
        SubjectAverageGrade bottom = em.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();

        query.orderBy(cb.desc(avgGrade));
        SubjectAverageGrade top = em.createQuery(query)
                .setMaxResults(1)
                .getSingleResult();

        return TopAndBottomPerformingSubjects.builder()
                .bottomSubjectAverageGrade(bottom.getAverageGrade())
                .bottomSubject(bottom.getSubject())
                .topSubjectAverageGrade(top.getAverageGrade())
                .topSubject(top.getSubject())
                .build();
    }

}

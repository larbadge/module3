package repository;

import dto.SubjectAverageGrade;
import dto.TopAndBottomPerformingSubjects;
import model.Student;
import model.Student_;
import model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

import static jpa.JpaUtil.getEntityManager;

class SubjectRepositoryImpl implements SubjectRepository {

    @Override
    public TopAndBottomPerformingSubjects getTopAndBottomPerformingSubjects() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SubjectAverageGrade> query = cb.createQuery(SubjectAverageGrade.class);
        Root<Student> root = query.from(Student.class);
        MapJoin<Student, Subject, Double> grades = root.join(Student_.grades);

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

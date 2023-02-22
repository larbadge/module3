package com.mikhalov.repository;

import com.mikhalov.dto.GroupAverageGrade;
import com.mikhalov.dto.GroupStudentsCount;
import com.mikhalov.model.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

import static com.mikhalov.util.JpaUtil.getEntityManager;

class GroupRepositoryImpl implements GroupRepository {

    @Override
    public Group getByName(String name) {
        EntityManager em = getEntityManager();

        return em.createQuery("Select g FROM Group g WHERE g.name = :name", Group.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<String> getNamesByPattern(String name) {
        String jpql = "SELECT g.name FROM Group g WHERE g.name LIKE :name";
        return getEntityManager().createQuery(jpql, String.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<GroupStudentsCount> countStudensByEach() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<GroupStudentsCount> query = cb.createQuery(GroupStudentsCount.class);
        Root<Group> root = query.from(Group.class);

        ListJoin<Group, Student> join = root.join(Group_.students);
        query.select(cb.construct(GroupStudentsCount.class,
                        root.get(Group_.name), cb.count(join)))
                .groupBy(root.get(Group_.id));

        return em.createQuery(query).getResultList();
    }

    @Override
    public List<GroupAverageGrade> getAverageGrades() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<GroupAverageGrade> query = cb.createQuery(GroupAverageGrade.class);
        Root<Group> root = query.from(Group.class);
        MapJoin<Student, Subject, Integer> join = root.join(Group_.students).join(Student_.grades);
        query.select(cb.construct(GroupAverageGrade.class, root.get(Group_.name), cb.avg(join.value())))
                .groupBy(root.get(Group_.id));

        return getEntityManager().createQuery(query).getResultList();
    }

}

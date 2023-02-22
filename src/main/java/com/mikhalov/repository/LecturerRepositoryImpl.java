package com.mikhalov.repository;

import com.mikhalov.model.Lecturer;
import com.mikhalov.model.Lecturer_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.mikhalov.util.JpaUtil.getEntityManager;

class LecturerRepositoryImpl implements LecturerRepository {

    @Override
    public List<Lecturer> getAllByNameOrLastname(String name) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Lecturer> query = cb.createQuery(Lecturer.class);

        Root<Lecturer> root = query.from(Lecturer.class);
        query.where(cb.or(
                cb.like(root.get(Lecturer_.firstName), name),
                cb.like(root.get(Lecturer_.lastName), name)
        ));

        return em.createQuery(query).getResultList();
    }

}

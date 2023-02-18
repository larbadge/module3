package repository;

import model.Lecturer;
import model.Lecturer_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static jpa.JpaUtil.getEntityManager;

class LecturerRepositoryImpl implements LecturerRepository {

    @Override
    public List<Lecturer> getAllByNameOrLastname(String name) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Lecturer> query = cb.createQuery(Lecturer.class);

        Root<Lecturer> root = query.from(Lecturer.class);

        Predicate names = cb.or(
                cb.like(cb.upper(root.get(Lecturer_.firstName)), name.toUpperCase()),
                cb.like(cb.upper(root.get(Lecturer_.lastName)), name.toUpperCase())
        );

        query.where(names);

        return em.createQuery(query).getResultList();
    }
}

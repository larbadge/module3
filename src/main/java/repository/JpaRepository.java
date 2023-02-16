package repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static jpa.JpaUtil.doWithinTransaction;
import static jpa.JpaUtil.getEntityManager;

public class JpaRepository<T> implements Repository<T>{
    private final Class<T> aClass;

    public JpaRepository(Class<T> aClass) {
        this.aClass = aClass;
    }

    @Override
    public void save(T t) {
        doWithinTransaction(em -> em.persist(t));
    }

    @Override
    public Optional<T> getById(String id) {
        EntityManager em = getEntityManager();
        return Optional.ofNullable(em.find(aClass, id));
    }

    @Override
    public List<T> getAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("from " + aClass.getName(), aClass).getResultList();
    }

    @Override
    public void delete(String id) {
        EntityManager em = getEntityManager();
        em.createQuery("delete " + aClass.getName(), aClass).executeUpdate();
    }

    @Override
    public void deleteAll() {
        EntityManager em = getEntityManager();
        em.createQuery("delete " + aClass.getName()).executeUpdate();
    }
}

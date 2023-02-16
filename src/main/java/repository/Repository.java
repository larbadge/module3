package repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    void save(T t);

    Optional<T> getById(String id);

    List<T> getAll();

    void delete(String id);

    void deleteAll();

}

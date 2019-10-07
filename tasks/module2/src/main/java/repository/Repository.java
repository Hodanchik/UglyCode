package repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    long add(T entity);
    Optional<T> findTextLeaf(Specification<T> spec);
}

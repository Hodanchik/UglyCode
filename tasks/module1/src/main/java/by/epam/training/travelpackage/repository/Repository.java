package by.epam.training.travelpackage.repository;

import java.util.List;

public interface Repository<T> {
    void add(T entity);
    void remove(T entity);
    List<T> findAllByParameter(Specification<T> spec);
}

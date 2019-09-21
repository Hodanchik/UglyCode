package by.epam.training.travelpackage.repository;

import by.epam.training.travelpackage.repository.specification.Specification;

import java.util.List;

public interface Repository<T> {
    void add(T entity);
    void remove(T entity);
    List<T> findAllByParameter(Specification<T> spec);
}

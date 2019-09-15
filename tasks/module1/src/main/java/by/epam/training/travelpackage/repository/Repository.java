package by.epam.training.travelpackage.repository;

public interface Repository<T> {

    T find(Specification<T> specification) throws NoSuchFieldException;
    void save(T entity);
    void delete(T entity);
}

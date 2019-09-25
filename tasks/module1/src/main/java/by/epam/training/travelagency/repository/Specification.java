package by.epam.training.travelagency.repository;

public interface Specification<T> {
    boolean match(T entity);

    default Specification<T> and(Specification<T> other) {

        return entity -> match(entity) && other.match(entity);
    }
}
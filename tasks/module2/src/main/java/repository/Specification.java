package repository;

public interface Specification <T> {
    boolean match(T entity);
}

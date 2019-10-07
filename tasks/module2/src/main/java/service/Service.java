package service;

public interface Service<T> {
    long saveText(T text);
    T loadText(long id);

}

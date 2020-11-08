package app.repo;

import java.util.List;

public interface RepositoryI<T>{
    void save(T item);

    void delete(T item);

    List<T> getAll();

    List<T> getListWithParam(String field, Object param);

    T getById(Integer id);
}

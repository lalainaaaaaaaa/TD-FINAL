package edu.soccer.app.dao.operations;

import java.util.List;

public interface BestclubsCrudOperations<T> {
    List<T> getAll(int page, int size);
    T findById(Long id);
    List<T> saveAll(List<T> entities);
    T create(T entity);
    T read(int id);
    List<T> readAll();
    T update(T entity);
    boolean delete(int id);
}

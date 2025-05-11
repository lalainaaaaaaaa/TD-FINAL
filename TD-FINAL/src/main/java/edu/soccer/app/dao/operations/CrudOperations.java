package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;

import java.util.List;

public interface CrudOperations<E> {
    List<E> getAll(int page, int size);

    E findById(Long id);

    // Both create (if does not exist) or update (if exist) entities
    List<E> saveAll(List<E> entities);

    clubs create(clubs club);

    clubs read(int id);

    List<clubs> readAll();

    clubs update(clubs club);

    boolean delete(int id);
}

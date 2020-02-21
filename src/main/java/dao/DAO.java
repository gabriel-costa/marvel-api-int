package dao;

import entity.Entity;

public interface DAO {

    Entity getById(Integer id);

    Entity getAll();
}

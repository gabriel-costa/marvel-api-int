package dao;

import entity.Entity;

import java.sql.SQLException;

public interface DAO {

    Entity getById(int id);

    Entity[] getAll() throws SQLException;
}

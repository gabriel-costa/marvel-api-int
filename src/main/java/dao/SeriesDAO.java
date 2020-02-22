package dao;

import configuration.DatabaseConnectionConfiguration;
import entity.Series;

public class SeriesDAO implements DAO {

    DatabaseConnectionConfiguration dbConnConfig = new DatabaseConnectionConfiguration();

    @Override
    public Series getById(int id) {
        return null;
    }

    @Override
    public Series[] getAll() {
        return null;
    }
}

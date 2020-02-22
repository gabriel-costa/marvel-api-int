package dao;

import configuration.DatabaseConnectionConfiguration;
import entity.Series;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeriesDAO implements DAO {

    @Override
    public Series getById(int id) throws SQLException {
        Series series;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.series where id=" + id);
            resultSet.next();
            series = new Series(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getDate("modified"),
                    resultSet.getString("resourceURI"));
        } catch (SQLException e) {
            System.out.println("Failed on getById series query!");
            throw new SQLException("Failed on getById series query!", e);
        }
        return series;
    }

    @Override
    public Series[] getAll() throws SQLException {
        Series[] seriesArray;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.series");

            ArrayList<Series> series = new ArrayList<>();
            while (resultSet.next()) {
                series.add(new Series(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("modified"),
                        resultSet.getString("resourceURI")));
            }
            seriesArray = series.toArray(new Series[series.size()]);
        } catch (SQLException e) {
            System.out.println("Failed on getAll series query!");
            throw new SQLException("Failed on getAll series query!", e);
        }
        return seriesArray;
    }

    public Series[] getSeriesByCharacterId(int id) throws SQLException {
        Series[] seriesArray;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT series_id FROM public.character_series where character_id=" + id);
            ArrayList<Series> series = new ArrayList<>();
            while (resultSet.next()) {
                series.add(getById(resultSet.getInt("series_id")));
            }
            seriesArray = series.toArray(new Series[series.size()]);
        } catch (SQLException e) {
            System.out.println("Failed on getSeriesByCharacterId series query!");
            throw new SQLException("Failed on getSeriesByCharacterId series query!", e);
        }
        return seriesArray;
    }
}

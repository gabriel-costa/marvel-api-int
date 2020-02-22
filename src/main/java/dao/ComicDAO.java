package dao;

import configuration.DatabaseConnectionConfiguration;
import entity.Comic;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ComicDAO implements DAO {

    @Override
    public Comic[] getAll() {
        throw new NotImplementedException();
    }

    @Override
    public Comic getById(int id) throws SQLException {
        Comic comic;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.comic where id=" + id);
            resultSet.next();
            comic = new Comic(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getDate("modified"),
                    resultSet.getString("resourceURI"),
                    resultSet.getInt("pageCount"),
                    resultSet.getInt("series"));
        } catch (SQLException e) {
            System.out.println("Failed on getById comics query!");
            throw new SQLException("Failed on getById comics query!", e);
        }
        return comic;
    }

    public Comic[] getComicsByCharacterId(int id) throws SQLException {
        Comic[] comicArray;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT comic_id FROM public.character_comic where character_id=" + id);
            ArrayList<Comic> comics = new ArrayList<>();
            while (resultSet.next()) {
                comics.add(getById(resultSet.getInt("comic_id")));
            }
            comicArray = comics.toArray(new Comic[comics.size()]);
        } catch (SQLException e) {
            System.out.println("Failed on getComicsByCharacterId comics query!");
            throw new SQLException("Failed on getComicsByCharacterId comics query!", e);
        }
        return comicArray;
    }
}

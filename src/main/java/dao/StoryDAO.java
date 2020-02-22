package dao;

import configuration.DatabaseConnectionConfiguration;
import entity.Story;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StoryDAO implements DAO {

    @Override
    public Story[] getAll() {
        throw new NotImplementedException();
    }

    @Override
    public Story getById(int id) throws SQLException {
        Story story;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.story where id=" + id);
            resultSet.next();
            story = new Story(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getDate("modified"),
                    resultSet.getString("resourceURI"));
        } catch (SQLException e) {
            System.out.println("Failed on getById stories query!");
            throw new SQLException("Failed on getById stories query!", e);
        }
        return story;
    }

    public Story[] getStoriesByCharacterId(int id) throws SQLException {
        Story[] storyArray;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT story_id FROM public.character_story where character_id=" + id);
            ArrayList<Story> stories = new ArrayList<>();
            while (resultSet.next()) {
                stories.add(getById(resultSet.getInt("story_id")));
            }
            storyArray = stories.toArray(new Story[stories.size()]);
        } catch (SQLException e) {
            System.out.println("Failed on getStoriesByCharacterId stories query!");
            throw new SQLException("Failed on getStoriesByCharacterId stories query!", e);
        }
        return storyArray;
    }
}
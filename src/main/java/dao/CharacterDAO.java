package dao;

import configuration.DatabaseConnectionConfiguration;
import entity.Character;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CharacterDAO implements DAO {

    @Override
    public Character getById(int id) throws SQLException {
        Character character;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.character where id=" + id);
            if(resultSet.next()) {
                character = new Character(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDate("modified"),
                        resultSet.getString("resourceURI"));
            } else {
                character = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed on getById characters query!");
            throw new SQLException("Failed on getById characters query!", e);
        }
        return character;
    }

    @Override
    public Character[] getAll() throws SQLException {
        Character[] characterArray;
        try {
            ArrayList<Character> characters = new ArrayList<>();
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.character");

            while (resultSet.next()) {
                characters.add(new Character(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDate("modified"),
                        resultSet.getString("resourceURI")
                ));
            }
            characterArray = characters.toArray(new Character[characters.size()]);
        } catch (SQLException e) {
            System.out.println("Failed on getAll characters query!");
            throw new SQLException("Failed on getAll characters query!", e);
        }
        return characterArray;
    }
}

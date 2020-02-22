package dao;

import configuration.DatabaseConnectionConfiguration;
import entity.Character;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CharacterDAO implements DAO {

    @Override
    public Character getById(int id) {
        return null;
    }

    @Override
    public Character[] getAll() throws SQLException {
        Character[] characterArray = null;
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
                characterArray = (Character[]) characters.toArray();
            }
        } catch (SQLException e) {
            System.out.println("Failed on getAll characters query!");
            throw e;
        }
        return characterArray;
    }
}

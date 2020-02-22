package dao;

import configuration.DatabaseConnectionConfiguration;
import entity.Event;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EventDAO implements DAO {

    @Override
    public Event[] getAll() {
        throw new NotImplementedException();
    }

    @Override
    public Event getById(int id) throws SQLException {
        Event event;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.event where id=" + id);
            resultSet.next();
            event = new Event(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getDate("modified"),
                    resultSet.getString("resourceURI"),
                    resultSet.getInt("next_event"),
                    resultSet.getInt("previous_event"));
        } catch (SQLException e) {
            System.out.println("Failed on getById events query!");
            throw new SQLException("Failed on getById events query!", e);
        }
        return event;
    }

    public Event[] getEventsByCharacterId(int id) throws SQLException {
        Event[] eventArray;
        try {
            Statement statement = DatabaseConnectionConfiguration.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT event_id FROM public.character_event where character_id=" + id);
            ArrayList<Event> events = new ArrayList<>();
            while (resultSet.next()) {
                events.add(getById(resultSet.getInt("event_id")));
            }
            eventArray = events.toArray(new Event[events.size()]);
        } catch (SQLException e) {
            System.out.println("Failed on getEventsByCharacterId events query!");
            throw new SQLException("Failed on getEventsByCharacterId events query!", e);
        }
        return eventArray;
    }
}

package service;

import bean.Event;
import bean.simple.EventSimple;
import dao.EventDAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;

public class EventService {

    private static final EventDAO eventDao = new EventDAO();

    public Event[] getAllEvents() {
        throw new NotImplementedException();
    }

    public Event getEventById(int id) {
        throw new NotImplementedException();
    }

    public EventSimple[] getEventsByCharacterId(int id) throws SQLException {
        return eventEntityArrayToSimpleBeanArray(eventDao.getEventsByCharacterId(id));
    }

    private EventSimple[] eventEntityArrayToSimpleBeanArray(entity.Event[] eventsByCharacterId) {
        EventSimple[] eventsSimple = new EventSimple[eventsByCharacterId.length];
        for (int i = 0; i < eventsByCharacterId.length; i++) {
            eventsSimple[i] = new EventSimple(
                    eventsByCharacterId[i].getId(),
                    eventsByCharacterId[i].getTitle(),
                    eventsByCharacterId[i].getDescription(),
                    eventsByCharacterId[i].getModified(),
                    eventsByCharacterId[i].getResourceURI()
            );
        }
        return eventsSimple;
    }
}

package service;

import bean.Event;
import bean.simple.EventSimple;
import dao.EventDAO;

import java.sql.SQLException;

public class EventService {

    private static final EventDAO eventDao = new EventDAO();

    private static final CharacterService characterService = new CharacterService();
    private static final ComicService comicService = new ComicService();
    private static final SeriesService seriesService = new SeriesService();
    private static final StoryService storyService = new StoryService();

    public Event[] getAllEvents() throws SQLException {
        return eventEntityArrayToBeanArray(eventDao.getAll());
    }

    public Event getEventById(int id) throws SQLException {
        return eventEntityToBean(eventDao.getById(id));
    }

    public EventSimple[] getEventsByCharacterId(int id) throws SQLException {
        return eventEntityArrayToSimpleBeanArray(eventDao.getEventsByCharacterId(id));
    }

    public EventSimple[] getEventsBySeriesId(int id) throws SQLException {
        return eventEntityArrayToSimpleBeanArray(eventDao.getEventsBySeriesId(id));
    }

    public EventSimple[] getEventsByComicId(int id) {
        return null;
    }

    public EventSimple[] getEventsByStoryId(int id) {
        return null;
    }

    private Event[] eventEntityArrayToBeanArray(entity.Event[] entityEvents) throws SQLException {
        Event[] events = new Event[entityEvents.length];
        for (int i = 0; i < entityEvents.length; i++) {
            events[i] = eventEntityToBean(entityEvents[i]);
        }
        return events;
    }

    private Event eventEntityToBean(entity.Event entityEvent) throws SQLException {
        return new Event(new EventSimple(entityEvent.getId(),
                entityEvent.getTitle(),
                entityEvent.getDescription(),
                entityEvent.getModified(),
                entityEvent.getResourceURI()),
                getEventById(entityEvent.getNextEvent()).getEventSimple(),
                getEventById(entityEvent.getPreviousEvent()).getEventSimple(),
                characterService.getCharactersByEventId(entityEvent.getId()),
                comicService.getComicsByEventId(entityEvent.getId()),
                storyService.getStoriesByEventId(entityEvent.getId()),
                seriesService.getSeriesByEventId(entityEvent.getId())
        );
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

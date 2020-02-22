package service;

import bean.Series;
import bean.simple.SeriesSimple;
import dao.SeriesDAO;

import java.sql.SQLException;

public class SeriesService {

    private static final SeriesDAO seriesDao = new SeriesDAO();

    private static final CharacterService characterService = new CharacterService();
    private static final ComicService comicService = new ComicService();
    private static final EventService eventService = new EventService();
    private static final StoryService storyService = new StoryService();

    public Series[] getAllSeries() throws SQLException {
        return seriesEntityArrayToBeanArray(seriesDao.getAll());
    }

    public Series getSeriesById(int id) throws SQLException {
        return seriesEntityToBean(seriesDao.getById(id));
    }

    public SeriesSimple[] getSeriesByCharacterId(int id) throws SQLException {
        return seriesEntityArrayToSimpleBeanArray(seriesDao.getSeriesByCharacterId(id));
    }

    public SeriesSimple[] getSeriesByEventId(int id){
        return null;
    }

    public SeriesSimple[] getSeriesByStoryId(int id) {
        return null;
    }

    private Series[] seriesEntityArrayToBeanArray(entity.Series[] entitySeries) throws SQLException {
        Series[] series = new Series[entitySeries.length];
        for (int i = 0; i < entitySeries.length; i++) {
            series[i] = seriesEntityToBean(entitySeries[i]);
        }
        return series;
    }

    private Series seriesEntityToBean(entity.Series entitySeries) throws SQLException {
        return new Series(new SeriesSimple(entitySeries.getId(),
                entitySeries.getTitle(),
                entitySeries.getDescription(),
                entitySeries.getModified(),
                entitySeries.getResourceURI()),
                characterService.getCharactersBySeriesId(entitySeries.getId()),
                comicService.getComicsBySeriesId(entitySeries.getId()),
                eventService.getEventsBySeriesId(entitySeries.getId()),
                storyService.getStoriesBySeriesId(entitySeries.getId())
        );
    }

    private SeriesSimple[] seriesEntityArrayToSimpleBeanArray(entity.Series[] seriesByCharacterId) {
        SeriesSimple[] seriesSimple = new SeriesSimple[seriesByCharacterId.length];
        for (int i = 0; i < seriesByCharacterId.length; i++) {
            seriesSimple[i] = new SeriesSimple(
                    seriesByCharacterId[i].getId(),
                    seriesByCharacterId[i].getTitle(),
                    seriesByCharacterId[i].getDescription(),
                    seriesByCharacterId[i].getModified(),
                    seriesByCharacterId[i].getResourceURI()
            );
        }
        return seriesSimple;
    }
}

package service;

import bean.Comic;
import bean.simple.ComicSimple;
import dao.ComicDAO;

import java.sql.SQLException;

public class ComicService {

    private static final ComicDAO comicDao = new ComicDAO();

    private static final CharacterService characterService = new CharacterService();
    private static final EventService eventService = new EventService();
    private static final SeriesService seriesService = new SeriesService();
    private static final StoryService storyService = new StoryService();

    public Comic[] getAllComics() throws SQLException {
        return comicEntityArrayToBeanArray(comicDao.getAll());
    }

    public Comic getComicById(int id) throws SQLException {
        return comicEntityToBean(comicDao.getById(id));
    }

    public ComicSimple[] getComicsByCharacterId(int id) throws SQLException {
        return comicEntityArrayToSimpleBeanArray(comicDao.getComicsByCharacterId(id));
    }

    public ComicSimple[] getComicsBySeriesId(int id) throws SQLException {
        return comicEntityArrayToSimpleBeanArray(comicDao.getComicsBySeriesId(id));
    }

    public ComicSimple[] getComicsByEventId(int id) {
        return null;
    }

    public ComicSimple[] getComicsByStoryId(int id) {
        return null;
    }

    private Comic[] comicEntityArrayToBeanArray(entity.Comic[] entityComics) throws SQLException {
        Comic[] comics = new Comic[entityComics.length];
        for (int i = 0; i < entityComics.length; i++) {
            comics[i] = comicEntityToBean(entityComics[i]);
        }
        return comics;
    }

    private Comic comicEntityToBean(entity.Comic entityComic) throws SQLException {
        return new Comic(new ComicSimple(entityComic.getId(),
                entityComic.getTitle(),
                entityComic.getDescription(),
                entityComic.getModified(),
                entityComic.getResourceURI(),
                entityComic.getPageCount()),
                seriesService.getSeriesById(entityComic.getSeries()).getSeriesSimple(),
                characterService.getCharactersByComicId(entityComic.getId()),
                eventService.getEventsByComicId(entityComic.getId()),
                storyService.getStoriesByComicId(entityComic.getId())
        );
    }

    private ComicSimple[] comicEntityArrayToSimpleBeanArray(entity.Comic[] comicsByCharacterId) {
        ComicSimple[] comicsSimple = new ComicSimple[comicsByCharacterId.length];
        for (int i = 0; i < comicsByCharacterId.length; i++) {
            comicsSimple[i] = new ComicSimple(
                    comicsByCharacterId[i].getId(),
                    comicsByCharacterId[i].getTitle(),
                    comicsByCharacterId[i].getDescription(),
                    comicsByCharacterId[i].getModified(),
                    comicsByCharacterId[i].getResourceURI(),
                    comicsByCharacterId[i].getPageCount()
            );
        }
        return comicsSimple;
    }
}

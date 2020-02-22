package service;

import bean.Story;
import bean.Story;
import bean.simple.StorySimple;
import bean.simple.StorySimple;
import dao.StoryDAO;

import java.sql.SQLException;

public class StoryService {

    private static final StoryDAO storyDao = new StoryDAO();

    private static final CharacterService characterService = new CharacterService();
    private static final ComicService comicService = new ComicService();
    private static final EventService eventService = new EventService();
    private static final SeriesService seriesService = new SeriesService();

    public Story[] getAllStory() throws SQLException {
        return storyEntityArrayToBeanArray(storyDao.getAll());
    }

    public Story getStoryById(int id) throws SQLException {
        return storyEntityToBean(storyDao.getById(id));
    }

    public StorySimple[] getStoriesByCharacterId(int id) throws SQLException {
        return storyEntityArrayToSimpleBeanArray(storyDao.getStoriesByCharacterId(id));
    }

    public StorySimple[] getStoriesBySeriesId(int id) throws SQLException {
        return storyEntityArrayToSimpleBeanArray(storyDao.getStoriesBySeriesId(id));

    }

    public StorySimple[] getStoriesByEventId(int id) {
        return null;
    }

    public StorySimple[] getStoriesByComicId(int id) {
        return null;
    }

    private Story[] storyEntityArrayToBeanArray(entity.Story[] entityStory) throws SQLException {
        Story[] story = new Story[entityStory.length];
        for (int i = 0; i < entityStory.length; i++) {
            story[i] = storyEntityToBean(entityStory[i]);
        }
        return story;
    }

    private Story storyEntityToBean(entity.Story entityStory) throws SQLException {
        return new Story(new StorySimple(entityStory.getId(),
                entityStory.getTitle(),
                entityStory.getDescription(),
                entityStory.getModified(),
                entityStory.getResourceURI()),
                comicService.getComicsByStoryId(entityStory.getId()),
                characterService.getCharactersByStoryId(entityStory.getId()),
                eventService.getEventsByStoryId(entityStory.getId()),
                seriesService.getSeriesByStoryId(entityStory.getId())
        );
    }

    private StorySimple[] storyEntityArrayToSimpleBeanArray(entity.Story[] storyByCharacterId) {
        StorySimple[] storySimple = new StorySimple[storyByCharacterId.length];
        for (int i = 0; i < storyByCharacterId.length; i++) {
            storySimple[i] = new StorySimple(
                    storyByCharacterId[i].getId(),
                    storyByCharacterId[i].getTitle(),
                    storyByCharacterId[i].getDescription(),
                    storyByCharacterId[i].getModified(),
                    storyByCharacterId[i].getResourceURI()
            );
        }
        return storySimple;
    }
}

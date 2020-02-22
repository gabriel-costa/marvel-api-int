package service;

import bean.Story;
import bean.simple.StorySimple;
import dao.StoryDAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;

public class StoryService {

    private static final StoryDAO storyDao = new StoryDAO();

    public Story[] getAllStory() throws SQLException {
        throw new NotImplementedException();
    }

    public Story getStoryById(int id) throws SQLException {
        throw new NotImplementedException();
    }

    public StorySimple[] getStoriesByCharacterId(int id) throws SQLException {
        return storyEntityArrayToSimpleBeanArray(storyDao.getStoriesByCharacterId(id));
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

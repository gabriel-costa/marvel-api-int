package service;


import bean.Character;
import bean.simple.*;
import dao.CharacterDAO;

import java.sql.SQLException;

public class CharacterService {

    private static final CharacterDAO characterDAO = new CharacterDAO();

    private static final ComicService comicService = new ComicService();
    private static final EventService eventService = new EventService();
    private static final SeriesService seriesService = new SeriesService();
    private static final StoryService storyService = new StoryService();

    public Character[] getAllCharacters() throws SQLException {
        return characterEntityArrayToBeanArray(characterDAO.getAll());
    }

    public Character getCharacterById(int id) throws SQLException {
        return characterEntityToBean(characterDAO.getById(id));
    }

    public ComicSimple[] getComicsByCharacterId(int id) throws SQLException {
        return comicService.getComicsByCharacterId(id);
    }

    public EventSimple[] getEventsByCharacterId(int id) throws SQLException {
        return eventService.getEventsByCharacterId(id);
    }

    public SeriesSimple[] getSeriesByCharacterId(int id) throws SQLException {
        return seriesService.getSeriesByCharacterId(id);
    }

    public StorySimple[] getStoriesByCharacterId(int id) throws SQLException {
        return storyService.getStoriesByCharacterId(id);
    }

    private Character[] characterEntityArrayToBeanArray(entity.Character[] entityCharacters) throws SQLException {
        Character[] characters = new Character[entityCharacters.length];
        for (int i = 0; i < entityCharacters.length; i++) {
            characters[i] = characterEntityToBean(entityCharacters[i]);
        }
        return characters;
    }

    private Character characterEntityToBean(entity.Character entityCharacter) throws SQLException {
        if (entityCharacter != null) {
            return new Character(new CharacterSimple(entityCharacter.getId(),
                    entityCharacter.getName(),
                    entityCharacter.getDescription(),
                    entityCharacter.getModified(),
                    entityCharacter.getResourceURI()),
                    comicService.getComicsByCharacterId(entityCharacter.getId()),
                    eventService.getEventsByCharacterId(entityCharacter.getId()),
                    seriesService.getSeriesByCharacterId(entityCharacter.getId()),
                    storyService.getStoriesByCharacterId(entityCharacter.getId())
            );
        }
        return null;
    }
}

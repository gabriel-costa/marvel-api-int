package service;


import bean.Character;
import bean.simple.CharacterSimple;
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

    public CharacterSimple[] getCharactersByComicId(int id) {
        return null;
    }

    public CharacterSimple[] getCharactersBySeriesId(int id) {
        return null;
    }

    public CharacterSimple[] getCharactersByEventId(int id) {
        return null;
    }

    public CharacterSimple[] getCharactersByStoryId(int id) {
        return null;
    }

    private Character[] characterEntityArrayToBeanArray(entity.Character[] entityCharacters) throws SQLException {
        Character[] characters = new Character[entityCharacters.length];
        for (int i = 0; i < entityCharacters.length; i++) {
            characters[i] = characterEntityToBean(entityCharacters[i]);
        }
        return characters;
    }

    private Character characterEntityToBean(entity.Character entityCharacter) throws SQLException {
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
}

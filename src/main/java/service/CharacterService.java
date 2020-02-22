package service;


import bean.Character;
import dao.CharacterDAO;

import java.sql.SQLException;

public class CharacterService {

    private static final CharacterDAO characterDAO = new CharacterDAO();

    private static final ComicService comicService = new ComicService();
    private static final EventService eventService = new EventService();
    private static final SeriesService seriesService = new SeriesService();
    private static final StoryService storyService = new StoryService();


    public Character[] getAllCharacters() throws SQLException {
        entity.Character[] entityCharacters = characterDAO.getAll();
        Character[] characters = characterEntityArrayToBeanArray(entityCharacters);
        return characters;
    }

    public Character getCharacterById(String id) {
        return null;
    }

    private Character[] characterEntityArrayToBeanArray(entity.Character[] entityCharacters) {
        Character[] characters = new Character[entityCharacters.length];
        for (int i = 0; i < entityCharacters.length; i++) {
            characters[i] = characterEntityToBean(entityCharacters[i]);
        }
        return characters;
    }

    private Character characterEntityToBean(entity.Character entityCharacter) {
        return new Character(
                entityCharacter.getId(),
                entityCharacter.getName(),
                entityCharacter.getDescription(),
                entityCharacter.getModified(),
                entityCharacter.getResourceURI(),
                comicService.getComicsByCharacterId(entityCharacter.getId()),
                eventService.getEventsByCharacterId(entityCharacter.getId()),
                seriesService.getSeriesByCharacterId(entityCharacter.getId()),
                storyService.getStoriesByCharacterId(entityCharacter.getId())
        );
    }
}

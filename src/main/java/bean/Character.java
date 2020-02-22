package bean;

import bean.simple.*;

public class Character {
    private CharacterSimple characterSimple;
    private ComicSimple[] comics;
    private EventSimple[] events;
    private SeriesSimple[] series;
    private StorySimple[] stories;

    public Character(CharacterSimple characterSimple, ComicSimple[] comics, EventSimple[] events, SeriesSimple[] series, StorySimple[] stories) {
        this.characterSimple = characterSimple;
        this.comics = comics;
        this.events = events;
        this.series = series;
        this.stories = stories;
    }

    public CharacterSimple getCharacterSimple() {
        return characterSimple;
    }

    public void setCharacterSimple(CharacterSimple characterSimple) {
        this.characterSimple = characterSimple;
    }

    public ComicSimple[] getComics() {
        return comics;
    }

    public void setComics(ComicSimple[] comics) {
        this.comics = comics;
    }

    public EventSimple[] getEvents() {
        return events;
    }

    public void setEvents(EventSimple[] events) {
        this.events = events;
    }

    public SeriesSimple[] getSeries() {
        return series;
    }

    public void setSeries(SeriesSimple[] series) {
        this.series = series;
    }

    public StorySimple[] getStories() {
        return stories;
    }

    public void setStories(StorySimple[] stories) {
        this.stories = stories;
    }
}
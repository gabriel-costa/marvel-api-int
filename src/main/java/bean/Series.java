package bean;

import bean.simple.*;

import java.util.Date;

public class Series {
    private SeriesSimple seriesSimple;
    private CharacterSimple[] characters;
    private ComicSimple[] comics;
    private EventSimple[] events;
    private StorySimple[] stories;

    public Series(SeriesSimple seriesSimple, CharacterSimple[] characters, ComicSimple[] comics, EventSimple[] events, StorySimple[] stories) {
        this.seriesSimple = seriesSimple;
        this.characters = characters;
        this.comics = comics;
        this.events = events;
        this.stories = stories;
    }

    public SeriesSimple getSeriesSimple() {
        return seriesSimple;
    }

    public void setSeriesSimple(SeriesSimple seriesSimple) {
        this.seriesSimple = seriesSimple;
    }

    public CharacterSimple[] getCharacters() {
        return characters;
    }

    public void setCharacters(CharacterSimple[] characters) {
        this.characters = characters;
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

    public StorySimple[] getStories() {
        return stories;
    }

    public void setStories(StorySimple[] stories) {
        this.stories = stories;
    }
}

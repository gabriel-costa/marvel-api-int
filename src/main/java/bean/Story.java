package bean;

import bean.simple.*;

import java.util.Date;

public class Story {
    private StorySimple storySimple;
    private ComicSimple[] comics;
    private CharacterSimple[] characters;
    private EventSimple[] events;
    private SeriesSimple[] series;

    public Story(StorySimple storySimple, ComicSimple[] comics, CharacterSimple[] characters, EventSimple[] events, SeriesSimple[] series) {
        this.storySimple = storySimple;
        this.comics = comics;
        this.characters = characters;
        this.events = events;
        this.series = series;
    }

    public StorySimple getStorySimple() {
        return storySimple;
    }

    public void setStorySimple(StorySimple storySimple) {
        this.storySimple = storySimple;
    }

    public ComicSimple[] getComics() {
        return comics;
    }

    public void setComics(ComicSimple[] comics) {
        this.comics = comics;
    }

    public CharacterSimple[] getCharacters() {
        return characters;
    }

    public void setCharacters(CharacterSimple[] characters) {
        this.characters = characters;
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
}

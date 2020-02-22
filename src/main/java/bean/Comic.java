package bean;

import bean.simple.*;

public class Comic {
    private ComicSimple comicSimple;
    private SeriesSimple series;
    private CharacterSimple[] characters;
    private EventSimple[] events;
    private StorySimple[] stories;

    public Comic(ComicSimple comicSimple, SeriesSimple series, CharacterSimple[] characters, EventSimple[] events, StorySimple[] stories) {
        this.comicSimple = comicSimple;
        this.series = series;
        this.characters = characters;
        this.events = events;
        this.stories = stories;
    }

    public ComicSimple getComicSimple() {
        return comicSimple;
    }

    public void setComicSimple(ComicSimple comicSimple) {
        this.comicSimple = comicSimple;
    }

    public SeriesSimple getSeries() {
        return series;
    }

    public void setSeries(SeriesSimple series) {
        this.series = series;
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

    public StorySimple[] getStories() {
        return stories;
    }

    public void setStories(StorySimple[] stories) {
        this.stories = stories;
    }
}
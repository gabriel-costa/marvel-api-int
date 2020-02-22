package bean;

import bean.simple.*;

public class Event {
    private EventSimple eventSimple;
    private EventSimple next;
    private EventSimple previous;
    private CharacterSimple[] characters;
    private ComicSimple[] comics;
    private StorySimple[] stories;
    private SeriesSimple[] series;

    public Event(EventSimple eventSimple, EventSimple next, EventSimple previous, CharacterSimple[] characters, ComicSimple[] comics, StorySimple[] stories, SeriesSimple[] series) {
        this.eventSimple = eventSimple;
        this.next = next;
        this.previous = previous;
        this.characters = characters;
        this.comics = comics;
        this.stories = stories;
        this.series = series;
    }

    public EventSimple getEventSimple() {
        return eventSimple;
    }

    public void setEventSimple(EventSimple eventSimple) {
        this.eventSimple = eventSimple;
    }

    public EventSimple getNext() {
        return next;
    }

    public void setNext(EventSimple next) {
        this.next = next;
    }

    public EventSimple getPrevious() {
        return previous;
    }

    public void setPrevious(EventSimple previous) {
        this.previous = previous;
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

    public StorySimple[] getStories() {
        return stories;
    }

    public void setStories(StorySimple[] stories) {
        this.stories = stories;
    }

    public SeriesSimple[] getSeries() {
        return series;
    }

    public void setSeries(SeriesSimple[] series) {
        this.series = series;
    }
}

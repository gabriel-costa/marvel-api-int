package bean;

import bean.simple.ComicSimple;
import bean.simple.EventSimple;
import bean.simple.SeriesSimple;
import bean.simple.StorySimple;

public class ListResponse {
    private ComicSimple[] comics;
    private EventSimple[] events;
    private SeriesSimple[] series;
    private StorySimple[] stories;

    public ListResponse(ComicSimple[] comics, EventSimple[] events, SeriesSimple[] series, StorySimple[] stories) {
        this.comics = comics;
        this.events = events;
        this.series = series;
        this.stories = stories;
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

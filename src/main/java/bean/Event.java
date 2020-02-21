package bean;

import java.util.Date;

public class Event {
    private Integer id;
    private String title;
    private String description;
    private Date modified;
    private String resourceURI;
    private Event next;
    private Event previous;
    private Comic[] comics;
    private Story[] stories;
    private Series[] series;

    public Event(Integer id, String title, String description, Date modified, String resourceURI, Event next, Event previous, Comic[] comics, Story[] stories, Series[] series) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.next = next;
        this.previous = previous;
        this.comics = comics;
        this.stories = stories;
        this.series = series;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Event getNext() {
        return next;
    }

    public void setNext(Event next) {
        this.next = next;
    }

    public Event getPrevious() {
        return previous;
    }

    public void setPrevious(Event previous) {
        this.previous = previous;
    }

    public Comic[] getComics() {
        return comics;
    }

    public void setComics(Comic[] comics) {
        this.comics = comics;
    }

    public Story[] getStories() {
        return stories;
    }

    public void setStories(Story[] stories) {
        this.stories = stories;
    }

    public Series[] getSeries() {
        return series;
    }

    public void setSeries(Series[] series) {
        this.series = series;
    }
}

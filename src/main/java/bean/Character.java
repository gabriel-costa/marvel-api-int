package bean;

import java.util.Date;

public class Character {
    private Integer id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private Comic[] comics;
    private Story[] stories;
    private Event[] events;
    private Series[] series;

    public Character(Integer id, String name, String description, Date modified, String resourceURI, Comic[] comics, Story[] stories, Event[] events, Series[] series) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.comics = comics;
        this.stories = stories;
        this.events = events;
        this.series = series;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Series[] getSeries() {
        return series;
    }

    public void setSeries(Series[] series) {
        this.series = series;
    }
}



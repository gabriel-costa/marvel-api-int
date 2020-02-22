package entity;

import java.util.Date;

public class Event extends Entity{
    private Integer id;
    private String title;
    private String description;
    private Date modified;
    private String resourceURI;
    private Integer nextEvent;
    private Integer previousEvent;
    private Integer[] characters;
    private Integer[] comics;
    private Integer[] stories;
    private Integer[] series;

    public Event(Integer id, String title, String description, Date modified, String resourceURI, Integer nextEvent, Integer previousEvent, Integer[] characters, Integer[] comics, Integer[] stories, Integer[] series) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.nextEvent = nextEvent;
        this.previousEvent = previousEvent;
        this.characters = characters;
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

    public Integer getNextEvent() {
        return nextEvent;
    }

    public void setNextEvent(Integer nextEvent) {
        this.nextEvent = nextEvent;
    }

    public Integer getPreviousEvent() {
        return previousEvent;
    }

    public void setPreviousEvent(Integer previousEvent) {
        this.previousEvent = previousEvent;
    }

    public Integer[] getCharacters() {
        return characters;
    }

    public void setCharacters(Integer[] characters) {
        this.characters = characters;
    }

    public Integer[] getComics() {
        return comics;
    }

    public void setComics(Integer[] comics) {
        this.comics = comics;
    }

    public Integer[] getStories() {
        return stories;
    }

    public void setStories(Integer[] stories) {
        this.stories = stories;
    }

    public Integer[] getSeries() {
        return series;
    }

    public void setSeries(Integer[] series) {
        this.series = series;
    }
}

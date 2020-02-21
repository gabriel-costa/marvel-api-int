package entity;

import java.util.Date;

public class Character extends Entity{
    private Integer id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private Integer[] comics;
    private Integer[] stories;
    private Integer[] events;
    private Integer[] series;

    public Character(Integer id, String name, String description, Date modified, String resourceURI, Integer[] comics, Integer[] stories, Integer[] events, Integer[] series) {
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

    public Integer[] getEvents() {
        return events;
    }

    public void setEvents(Integer[] events) {
        this.events = events;
    }

    public Integer[] getSeries() {
        return series;
    }

    public void setSeries(Integer[] series) {
        this.series = series;
    }
}
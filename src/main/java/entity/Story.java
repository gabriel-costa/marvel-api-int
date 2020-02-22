package entity;

import java.util.Date;

public class Story extends Entity{
    private Integer id;
    private String title;
    private String description;
    private Date modified;
    private String resourceURI;
    private Integer[] characters;
    private Integer[] comics;
    private Integer[] events;
    private Integer[] series;

    public Story(Integer id, String title, String description, Date modified, String resourceURI, Integer[] comics, Integer[] characters, Integer[] events, Integer[] series) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.comics = comics;
        this.characters = characters;
        this.events = events;
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

    public Integer[] getComics() {
        return comics;
    }

    public void setComics(Integer[] comics) {
        this.comics = comics;
    }

    public Integer[] getCharacters() {
        return characters;
    }

    public void setCharacters(Integer[] characters) {
        this.characters = characters;
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

package bean;

import java.util.Date;

public class Story {
    private Integer id;
    private String title;
    private String description;
    private Date modified;
    private String resourceURI;
    private Comic[] comics;
    private Character[] characters;
    private Event[] events;
    private Series[] series;

    public Story(Integer id, String title, String description, Date modified, String resourceURI, Comic[] comics, Character[] characters, Event[] events, Series[] series) {
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

    public Comic[] getComics() {
        return comics;
    }

    public void setComics(Comic[] comics) {
        this.comics = comics;
    }

    public Character[] getCharacters() {
        return characters;
    }

    public void setCharacters(Character[] characters) {
        this.characters = characters;
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

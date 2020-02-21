package bean;

import java.util.Date;

public class Comic {
    private Integer id;
    private String title;
    private String description;
    private Date modified;
    private String resourceURI;
    private Integer pageCount;
    private Series series;
    private Story[] stories;
    private Event[] events;

    public Comic(Integer id, String title, String description, Date modified, String resourceURI, Integer pageCount, Series series, Story[] stories, Event[] events) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.pageCount = pageCount;
        this.series = series;
        this.stories = stories;
        this.events = events;
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

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
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
}

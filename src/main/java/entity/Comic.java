package entity;

import java.util.Date;

public class Comic extends Entity{
    private Integer id;
    private String title;
    private String description;
    private Date modified;
    private String resourceURI;
    private Integer pageCount;
    private Integer series;
    private Integer[] stories;
    private Integer[] events;

    public Comic(Integer id, String title, String description, Date modified, String resourceURI, Integer pageCount, Integer series, Integer[] stories, Integer[] events) {
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

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
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
}

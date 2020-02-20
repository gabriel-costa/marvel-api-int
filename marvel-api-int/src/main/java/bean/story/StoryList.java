package bean.story;

public class StoryList {
    private Integer available;
    private Integer returned;
    private String collectionURI;
    private StorySummary items;

    public StoryList(Integer available, Integer returned, String collectionURI, StorySummary items) {
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public StorySummary getItems() {
        return items;
    }

    public void setItems(StorySummary items) {
        this.items = items;
    }
}

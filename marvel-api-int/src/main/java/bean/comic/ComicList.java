package bean.comic;

public class ComicList {
    private Integer available;
    private Integer returned;
    private String collectionURI;
    private ComicSummary[] items;

    public ComicList(Integer available, Integer returned, String collectionURI, ComicSummary[] items) {
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

    public ComicSummary[] getItems() {
        return items;
    }

    public void setItems(ComicSummary[] items) {
        this.items = items;
    }
}

package bean.series;

public class SeriesList {
    private Integer available;
    private Integer returned;
    private String collectionURI;
    private SeriesSummary[] items;

    public SeriesList(Integer available, Integer returned, String collectionURI, SeriesSummary[] items) {
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

    public SeriesSummary[] getItems() {
        return items;
    }

    public void setItems(SeriesSummary[] items) {
        this.items = items;
    }
}

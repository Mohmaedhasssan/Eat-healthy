package ws.idroid.sqlite;

public class Favourites {
    int id;
    String favourite,description;

    public Favourites(int id, String favourite, String description) {
        this.id = id;
        this.favourite = favourite;
        this.description = description;
    }
    public Favourites( String favourite, String description) {
        this.favourite = favourite;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

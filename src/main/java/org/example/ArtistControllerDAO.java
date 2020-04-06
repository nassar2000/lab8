package org.example;

public interface ArtistControllerDAO {

    public void create(String name, int artistId, int releaseYear);
    public void findByName(int artistId);
}

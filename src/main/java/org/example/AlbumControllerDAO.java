package org.example;

public interface AlbumControllerDAO {
    public void create(String name, String country);
    public void findByName(String name);
}

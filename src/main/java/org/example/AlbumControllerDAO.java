package org.example;

import java.sql.SQLException;
import java.util.List;

public interface AlbumControllerDAO {
    void create(String name, int artistId, int releaseYear) throws SQLException;
    List<AlbumControllerDAOimpl> findByArtist(int artistId) throws SQLException;

}

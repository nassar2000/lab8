package org.example;

import java.sql.SQLException;
import java.util.List;

public interface ArtistControllerDAO {

    void create(String name, String country) throws SQLException;
    List<ArtistControllerDAOimpl> findByName(String name) throws SQLException;
}

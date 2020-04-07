package org.example;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AlbumControllerDAOimpl implements AlbumControllerDAO {

        @Override
        public void create(String name, int artistId, int releaseYear) throws SQLException {

            Db createAlbum=new Db();
            Statement createAlbumSt=createAlbum.getConnection().createStatement();
            String comanda="Insert into albums(name,artist_Id,release_Year) values('"+name+"',"+artistId+","+releaseYear+")";
            createAlbumSt.execute("USE MusicAlbums");
            createAlbumSt.execute(comanda);
            System.out.println("Inserare album reusita!");
            createAlbum.getConnection().close();
        }

        @Override
        public List<AlbumControllerDAOimpl> findByArtist(int artistId) throws SQLException {
            Db listAlbum=new Db();
            Statement listAlbumSt=listAlbum.getConnection().createStatement();
            String comanda2="select * from albums where artist_id="+artistId;
            listAlbumSt.execute("USE MusicAlbums");
            ResultSet rs1=listAlbumSt.executeQuery(comanda2);
            System.out.println("Detalii despre Album!");
            while(rs1.next())
                System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getInt(4));
            listAlbum.getConnection().close();


            return null;
        }
    }



package org.example;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    /* sqllite comenzi*/
    static String databaseCreation = "  CREATE DATABASE MusicAlbums ";/* aici am creat baza de date*/
    static String databaseDelete = " DROP DATABASE MusicAlbums ";/* aici sterg baza de date*/
    static String usernameAndPasswordCreation = "CREATE LOGIN dba WITH PASSWORD = 'sql'";/* aici creaz user si pass*/
    static String userAndPassDelete = "DROP LOGIN dba";/* aici sterg userul*/

    static String tableArtists = "create table artists(id INTEGER IDENTITY(1,1) PRIMARY KEY not null , name varchar(100) not null, country varchar(100))";/* aici am creat  tableArtists*/
    static String tableAlbums = "create table albums(id integer IDENTITY(1,1) PRIMARY KEY not null ,name varchar(100) not null,artist_id integer not null,release_year integer CONSTRAINT artist_id  FOREIGN KEY(artist_id) REFERENCES artists(id))";/* aici am creat  tableAlbums*/
    static String DeleteTableArtists = "drop table Artists";/* aici am sterg TableArtists */
    static String DeleteTableAlbumss = "drop table Albums";/* aici am sterg TableAlbums */


    public static void main(String args[]) throws SQLException {

        Connection connection = null;
        Statement statement = null;

        try {
            /*STEP  Register JDBC driver*/
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            /* Open a connection*/
          /*
          connection=DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-GTB6MF7;portNumber=1433;integratedSecurity=true;");*/
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-GTB6MF7;portNumber=1433;user=dba;password=sql;");
            System.out.println("secsesfuly");

            /* Execute a query*/
            statement = connection.createStatement();


            //createDatabase(statement);
            //dropDatabase(statement);

            /*createUserAndPass(statement);*/
            /* dropUserAndPass(statement); */

            //createTableArtist(statement);
           // createTableAlbums(statement);
           //dropTableArtist(statement);
            //dropTableAlbums(statement);

             //ArtistControllerDAOimpl artist=new ArtistControllerDAOimpl();
               AlbumControllerDAOimpl album=new AlbumControllerDAOimpl();

             //artist.create("Otis","SUA");
             //album.create("Casasda",1,1964);
            // artist.findByName("Otis");
            // album.findByArtist(1);


            /* finally block used to close resources*/
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("eroare");
        }


    }

    public static void createDatabase(Statement statDatabase) throws SQLException {
        System.out.println("Create a database having the name MusicAlbums");
        statDatabase.execute(databaseCreation); //nu returneaza un set de rezultate
        System.out.println("Done!");
    }

    public static void createUserAndPass(Statement statUserAndPass) throws SQLException {
        System.out.println("Create User and Pass");
        statUserAndPass.execute(usernameAndPasswordCreation);
        System.out.println("Done!");
    }

    public static void dropDatabase(Statement DatabaseDelete) throws SQLException {
        System.out.println("Drop a database having the name MusicAlbums");
        ResultSet database = DatabaseDelete.executeQuery(databaseDelete); //nu returneaza un set de rezultate
        System.out.println("Done!");
    }

    public static void dropUserAndPass(Statement UserAndPassDelete) throws SQLException {
        System.out.println("Drop a user and pass ");
        UserAndPassDelete.execute(userAndPassDelete); //nu returneaza un set de rezultate
        System.out.println("Done!");
    }

    public static void createTableArtist(Statement statArtist) throws SQLException {

        statArtist.execute("USE MusicAlbums");
        System.out.println("Create Table Artist ");
        ResultSet database = statArtist.executeQuery(tableArtists); //nu returneaza un set de rezultate
        System.out.println("Done!");
    }

    public static void createTableAlbums(Statement statAlbums) throws SQLException {
        statAlbums.execute("USE MusicAlbums");
        System.out.println("Create Table Albums ");
        statAlbums.execute(tableAlbums); //nu returneaza un set de rezultate
        System.out.println("Done!");
    }

    public static void dropTableArtist(Statement DeleteTableArtist) throws SQLException {
        DeleteTableArtist.execute("USE MusicAlbums");
        System.out.println("Drop Table Artist");
        ResultSet database = DeleteTableArtist.executeQuery(DeleteTableArtists); //nu returneaza un set de rezultate
        System.out.println("Done!");
    }

    public static void dropTableAlbums(Statement DeleteTableAlbums) throws SQLException {
        DeleteTableAlbums.execute("USE MusicAlbums");
        System.out.println("Drop Table Albums");
        ResultSet database = DeleteTableAlbums.executeQuery(DeleteTableAlbumss); //nu returneaza un set de rezultate
        System.out.println("Done!");
    }
}


package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db {

    private static Db dbIsntance;
    private Connection con = null;


    Db() {
        // private constructor //
    }

    public static Db getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new Db();
        }
        return dbIsntance;
    }

    public Connection getConnection() {


        try {
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-GTB6MF7;portNumber=1433;user=dba;password=sql;");
            System.out.println("successful!");
        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }


        return con;
    }
}

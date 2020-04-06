package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Hello world!
 *
 */
/*
public class App 
{
    public static void main( String[] args )

    {
        System.out.println( "Hello World!" );
    }

}

 */
class WhatIsJdbc{

    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:D:\\programe\\intilijWorkspaece\\lab8\\chinook.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Got it!");

        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

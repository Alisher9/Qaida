
/*
Name: Alisher Sattarbek
Faculty: Engineering
Course and group: 1EN03D
Description: JavaFX Project - Qaida
Teacher: Shamiluulu Shahriar
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {

    private static String url="jdbc:mysql://localhost:3306";
    private static String Password="root" ;
    private static String login="root";

    private Connection connection;

    public DBWorker(){
        try {
            connection = DriverManager.getConnection(("jdbc.mysql://localhost:3360/Project"),"root", "Alishsdu99");
            System.out.println("Connected to Database");
        } catch (SQLException w){
            w.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}

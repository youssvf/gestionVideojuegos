package com.example.GestionVideoJuegos.videojuego.infrastructure.data;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static Connection connection;

    private DBConnection(){}

    public static Connection getInstance(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://database-1.cabn5upwsapr.us-east-1.rds.amazonaws.com/gestionVideojuegos","admin","admin1234");
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return connection;
    }
}

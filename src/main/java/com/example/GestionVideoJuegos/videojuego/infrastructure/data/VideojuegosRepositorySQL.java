package com.example.GestionVideoJuegos.videojuego.infrastructure.data;

import com.example.GestionVideoJuegos.videojuego.domain.Videojuego;
import com.example.GestionVideoJuegos.videojuego.domain.VideojuegosRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VideojuegosRepositorySQL implements VideojuegosRepository {
    @Override
    public List<Videojuego> getAll() {
        List<Videojuego> videojuegos = new ArrayList<>();

        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from videojuegos;");

            while (rs.next()){
                videojuegos.add(new Videojuego(
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getInt("precio")
                ));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return videojuegos;
    }

    @Override
    public Videojuego getVideojuego(String nombre) {
        Videojuego videojuego = null;
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from videojuegos where nombre = '" + nombre  +"';");

            while (rs.next()){
                videojuego = new Videojuego(nombre, rs.getString("categoria"),rs.getInt("precio"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return videojuego;
    }

    @Override
    public Videojuego save(Videojuego videojuego) {

        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement("insert into videojuegos values(?,?,?)");

            statement.setString(1, videojuego.getNombre());
            statement.setString(2, videojuego.getCategoria());
            statement.setInt(3,videojuego.getPrecio());

            statement.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }


        return videojuego;
    }

    @Override
    public Videojuego update(String nombre, Integer precio) {
        Videojuego videojuego = null;
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement("UPDATE videojuegos set precio = ? where nombre = ?");
            statement.setInt(1,precio);
            statement.setString(2,nombre);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


        return videojuego;
    }

    @Override
    public Videojuego delete(String nombre) {
        return null;
    }
}

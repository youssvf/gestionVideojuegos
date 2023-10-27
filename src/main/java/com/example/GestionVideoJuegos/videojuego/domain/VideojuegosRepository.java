package com.example.GestionVideoJuegos.videojuego.domain;

import java.util.List;

public interface VideojuegosRepository {
    public List<Videojuego> getAll();
    public Videojuego getVideojuego(String nombre);
    public Videojuego save (Videojuego videojuego);
    public Videojuego update(String nombre, Integer precio);
    public Videojuego delete(String nombre);
}

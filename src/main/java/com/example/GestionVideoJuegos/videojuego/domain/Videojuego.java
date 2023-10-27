package com.example.GestionVideoJuegos.videojuego.domain;

public class Videojuego {
    private String nombre, categoria;
    private Integer precio;

    public Videojuego(String nombre, String categoria, Integer precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public Integer getPrecio() {
        return precio;
    }
}

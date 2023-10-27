package com.example.GestionVideoJuegos.videojuego.aplication;

import com.example.GestionVideoJuegos.videojuego.domain.Videojuego;
import com.example.GestionVideoJuegos.videojuego.domain.VideojuegosRepository;

import java.util.List;

public class VideojuegosUseCases {
    private final VideojuegosRepository videojuegosRepository;

    public VideojuegosUseCases(VideojuegosRepository videojuegosRepository){
        this.videojuegosRepository = videojuegosRepository;
    }

    public List<Videojuego> getAll(){
        return this.videojuegosRepository.getAll();
    }

    public Videojuego getVideojuego(String nombre){
        return this.videojuegosRepository.getVideojuego(nombre);
    }

    public Videojuego save(Videojuego videojuego){
        return this.videojuegosRepository.save(videojuego);
    }

    public Videojuego update(String nombre, Integer precio){
        return this.videojuegosRepository.update(nombre,precio);
    }

    public Videojuego delete(String nombre){
        return this.videojuegosRepository.delete(nombre);
    }
}

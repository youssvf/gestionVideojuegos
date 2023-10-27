package com.example.GestionVideoJuegos.videojuego.infrastructure;

import com.example.GestionVideoJuegos.videojuego.aplication.VideojuegosUseCases;
import com.example.GestionVideoJuegos.videojuego.domain.Videojuego;
import com.example.GestionVideoJuegos.videojuego.domain.VideojuegosRepository;
import com.example.GestionVideoJuegos.videojuego.infrastructure.data.VideojuegosRepositorySQL;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;

@RestController
public class VideojuegosRestController {
    private VideojuegosUseCases videojuegosUseCases;

    public VideojuegosRestController(){
        this.videojuegosUseCases = new VideojuegosUseCases(new VideojuegosRepositorySQL());
    }

    @GetMapping("videojuegos")
    public List<Videojuego> getAll(){
        return this.videojuegosUseCases.getAll();
    }

    @GetMapping("videojuegos/{nombre}")
    public Videojuego getVideojuego(@PathVariable String nombre){
        return this.videojuegosUseCases.getVideojuego(nombre);
    }

    @PostMapping(path = "videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Videojuego save(@RequestBody Videojuego videojuego){
        return this.videojuegosUseCases.save(videojuego);
    }

    @PutMapping(path = "videojuegos/{nombre}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Videojuego update(@PathVariable String nombre, @RequestBody Integer precio){
        return this.videojuegosUseCases.update(nombre, precio);
    }

}

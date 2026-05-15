package com.surftracker.controller;

import com.surftracker.entity.Favorito;
import com.surftracker.service.FavoritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
@CrossOrigin(origins = "*")
public class FavoritoController {

    private final FavoritoService favoritoService;

    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    @GetMapping
    public List<Favorito> listar() {
        return favoritoService.listar();
    }

    @GetMapping("/{id}")
    public Favorito obtenerPorId(@PathVariable Integer id) {
        return favoritoService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Favorito> listarPorUsuario(@PathVariable Integer idUsuario) {
        return favoritoService.listarPorUsuario(idUsuario);
    }

    @GetMapping("/localizacion/{idLocalizacion}")
    public List<Favorito> listarPorLocalizacion(@PathVariable Integer idLocalizacion) {
        return favoritoService.listarPorLocalizacion(idLocalizacion);
    }

    @PostMapping("/guardarFavorito")
    public Favorito guardar(@RequestBody Favorito favorito) {
        return favoritoService.guardar(favorito);
    }

    @DeleteMapping("/eliminarFavorito/{id}")
    public void eliminar(@PathVariable Integer id) {
        favoritoService.eliminar(id);
    }
}
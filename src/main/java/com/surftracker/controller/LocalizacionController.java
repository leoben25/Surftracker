package com.surftracker.controller;


import com.surftracker.entity.Localizacion;
import com.surftracker.service.LocalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/localizaciones")
@CrossOrigin(origins = "*")

public class LocalizacionController {

    @Autowired
    private LocalizacionService service;



    @PostMapping("registrarLocalizacion")
    public Localizacion registrar(
            @RequestBody Localizacion localizacion){

        return service.registrar(localizacion);

    }



    @GetMapping("/listaTodos")
    public List<Localizacion> listar(){

        return service.listar();

    }



    @GetMapping("/{id}")
    public Localizacion buscar(
            @PathVariable Integer id){

        return service.buscarPorId(id);

    }



    @PutMapping("actualizarLocalizacion")
    public Localizacion actualizar(
            @RequestBody Localizacion localizacion){

        return service.actualizar(localizacion);

    }



    @DeleteMapping("/eliminarLocalizacion/{id}")
    public void eliminar(
            @PathVariable Integer id){

        service.eliminar(id);

    }

}

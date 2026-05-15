package com.surftracker.controller;

import com.surftracker.entity.ConsultaPronostico;
import com.surftracker.service.ConsultaPronosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/consultapronosticos")
@CrossOrigin(origins = "*")

public class ConsultaPronosticoController {

    @Autowired
    private ConsultaPronosticoService service;


    @PostMapping
    public ConsultaPronostico registrar(
            @RequestBody ConsultaPronostico c){

        return service.registrar(c);

    }


    @GetMapping
    public List<ConsultaPronostico> listar(){

        return service.listar();

    }


    @GetMapping("/{id}")
    public ConsultaPronostico buscar(
            @PathVariable Integer id){

        return service.buscarPorId(id);

    }


    @PutMapping
    public ConsultaPronostico actualizar(
            @RequestBody ConsultaPronostico c){

        return service.actualizar(c);

    }


    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Integer id){

        service.eliminar(id);

    }

}

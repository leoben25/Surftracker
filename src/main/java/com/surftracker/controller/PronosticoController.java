package com.surftracker.controller;

import com.surftracker.entity.Pronostico;
import com.surftracker.service.PronosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/pronosticos")
@CrossOrigin(origins = "*")
public class PronosticoController {

    @Autowired
    private PronosticoService PronosticoService;

    @PostMapping("/InsertaPronostico")
    public ResponseEntity<?> InsertaPronostico(@RequestBody Pronostico obj) {
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdPronostico(0);
        Pronostico objSalida = PronosticoService.inserta(obj);
        salida.put("data", objSalida);
        salida.put("mensaje", "Registro de pronóstico exitoso");
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/listaTodos")
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(PronosticoService.listaTodos());
    }

    @GetMapping("/listaPorLocalizacion/{id}")
    public ResponseEntity<?> listarPorLocalizacion(@PathVariable int id) {
        return ResponseEntity.ok(PronosticoService.listaPorLocalizacion(id));
    }
}
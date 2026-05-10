package com.surftracker.controller;

import com.surftracker.entity.Notificacion;
import com.surftracker.service.NotificacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping
    public List<Notificacion> listar() {
        return notificacionService.listar();
    }

    @GetMapping("/{id}")
    public Notificacion obtenerPorId(@PathVariable Integer id) {
        return notificacionService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Notificacion> listarPorUsuario(@PathVariable Integer idUsuario) {
        return notificacionService.listarPorUsuario(idUsuario);
    }

    @GetMapping("/estado/{estadoLectura}")
    public List<Notificacion> listarPorEstadoLectura(@PathVariable String estadoLectura) {
        return notificacionService.listarPorEstadoLectura(estadoLectura);
    }

    @GetMapping("/riesgo/{nivelRiesgo}")
    public List<Notificacion> listarPorNivelRiesgo(@PathVariable String nivelRiesgo) {
        return notificacionService.listarPorNivelRiesgo(nivelRiesgo);
    }

    @PostMapping
    public Notificacion guardar(
            @RequestParam Integer idUsuario,
            @RequestParam(required = false) Integer idLocalizacion,
            @RequestBody Notificacion notificacion
    ) {
        return notificacionService.guardar(idUsuario, idLocalizacion, notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion actualizar(
            @PathVariable Integer id,
            @RequestBody Notificacion notificacion
    ) {
        return notificacionService.actualizar(id, notificacion);
    }

    @PutMapping("/{id}/leido")
    public Notificacion marcarComoLeida(@PathVariable Integer id) {
        return notificacionService.marcarComoLeida(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        notificacionService.eliminar(id);
    }
}

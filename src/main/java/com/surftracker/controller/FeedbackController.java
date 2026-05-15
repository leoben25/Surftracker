package com.surftracker.controller;

import com.surftracker.entity.Feedback;
import com.surftracker.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
@CrossOrigin(origins = "*")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> listar() {
        return feedbackService.listar();
    }

    @GetMapping("/{id}")
    public Feedback obtenerPorId(@PathVariable Integer id) {
        return feedbackService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Feedback> listarPorUsuario(@PathVariable Integer idUsuario) {
        return feedbackService.listarPorUsuario(idUsuario);
    }

    @GetMapping("/pronostico/{idPronostico}")
    public List<Feedback> listarPorPronostico(@PathVariable Integer idPronostico) {
        return feedbackService.listarPorPronostico(idPronostico);
    }

    @GetMapping("/calificacion/{calificacion}")
    public List<Feedback> listarPorCalificacion(@PathVariable Integer calificacion) {
        return feedbackService.listarPorCalificacion(calificacion);
    }

    @PostMapping("/guardarFeedback")
    public Feedback guardar(@RequestBody Feedback feedback) {
        Integer idUsuario = feedback.getUsuario().getIdUsuario();
        Integer idPronostico = feedback.getPronostico() != null ? feedback.getPronostico().getIdPronostico() : null;
        return feedbackService.guardar(idUsuario, idPronostico, feedback);
    }

    @PutMapping("/{id}")
    public Feedback actualizar(
            @PathVariable Integer id,
            @RequestBody Feedback feedback
    ) {
        return feedbackService.actualizar(id, feedback);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        feedbackService.eliminar(id);
    }
}
package com.surftracker.service;

import com.surftracker.entity.Feedback;
import com.surftracker.entity.Pronostico;
import com.surftracker.entity.Usuario;
import com.surftracker.repository.FeedbackRepository;
import com.surftracker.repository.PronosticoRepository;
import com.surftracker.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final UsuarioRepository usuarioRepository;
    private final PronosticoRepository pronosticoRepository;

    public FeedbackService(
            FeedbackRepository feedbackRepository,
            UsuarioRepository usuarioRepository,
            PronosticoRepository pronosticoRepository
    ) {
        this.feedbackRepository = feedbackRepository;
        this.usuarioRepository = usuarioRepository;
        this.pronosticoRepository = pronosticoRepository;
    }

    public List<Feedback> listar() {
        return feedbackRepository.findAll();
    }

    public Feedback obtenerPorId(Integer id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback no encontrado con ID: " + id));
    }

    public List<Feedback> listarPorUsuario(Integer idUsuario) {
        return feedbackRepository.findByUsuarioIdUsuario(idUsuario);
    }

    public List<Feedback> listarPorPronostico(Integer idPronostico) {
        return feedbackRepository.findByPronosticoIdPronostico(idPronostico);
    }

    public List<Feedback> listarPorCalificacion(Integer calificacion) {
        return feedbackRepository.findByCalificacion(calificacion);
    }

    public Feedback guardar(Integer idUsuario, Integer idPronostico, Feedback feedback) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

        feedback.setUsuario(usuario);

        if (idPronostico != null) {
            Pronostico pronostico = pronosticoRepository.findById(idPronostico)
                    .orElseThrow(() -> new RuntimeException("Pronóstico no encontrado con ID: " + idPronostico));
            feedback.setPronostico(pronostico);
        }

        feedback.setFechaFeedback(LocalDate.now());

        return feedbackRepository.save(feedback);
    }

    public Feedback actualizar(Integer id, Feedback datosActualizados) {
        Feedback feedback = obtenerPorId(id);

        feedback.setComentario(datosActualizados.getComentario());
        feedback.setCalificacion(datosActualizados.getCalificacion());

        return feedbackRepository.save(feedback);
    }

    public void eliminar(Integer id) {
        Feedback feedback = obtenerPorId(id);
        feedbackRepository.delete(feedback);
    }
}

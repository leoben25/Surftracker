package com.surftracker.repository;

import com.surftracker.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    List<Feedback> findByUsuarioIdUsuario(Integer idUsuario);

    List<Feedback> findByPronosticoIdPronostico(Integer idPronostico);

    List<Feedback> findByCalificacion(Integer calificacion);
}

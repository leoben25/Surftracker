package com.surftracker.repository;

import com.surftracker.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {

    List<Notificacion> findByUsuarioIdUsuario(Integer idUsuario);

    List<Notificacion> findByEstadoLectura(String estadoLectura);

    List<Notificacion> findByNivelRiesgo(String nivelRiesgo);
}

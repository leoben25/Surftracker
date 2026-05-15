package com.surftracker.service;

import com.surftracker.entity.Localizacion;
import com.surftracker.entity.Notificacion;
import com.surftracker.entity.Usuario;
import com.surftracker.repository.LocalizacionRepository;
import com.surftracker.repository.NotificacionRepository;
import com.surftracker.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private final UsuarioRepository usuarioRepository;
    private final LocalizacionRepository localizacionRepository;

    public NotificacionService(
            NotificacionRepository notificacionRepository,
            UsuarioRepository usuarioRepository,
            LocalizacionRepository localizacionRepository
    ) {
        this.notificacionRepository = notificacionRepository;
        this.usuarioRepository = usuarioRepository;
        this.localizacionRepository = localizacionRepository;
    }

    public List<Notificacion> listar() {
        return notificacionRepository.findAll();
    }

    public Notificacion obtenerPorId(Integer id) {
        return notificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada con ID: " + id));
    }

    public List<Notificacion> listarPorUsuario(Integer idUsuario) {
        return notificacionRepository.findByUsuarioIdUsuario(idUsuario);
    }

    public List<Notificacion> listarPorEstadoLectura(String estadoLectura) {
        return notificacionRepository.findByEstadoLectura(estadoLectura);
    }

    public List<Notificacion> listarPorNivelRiesgo(String nivelRiesgo) {
        return notificacionRepository.findByNivelRiesgo(nivelRiesgo);
    }

    public Notificacion guardar(Integer idUsuario, Integer idLocalizacion, Notificacion notificacion) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

        notificacion.setUsuario(usuario);

        if (idLocalizacion != null) {
            Localizacion localizacion = localizacionRepository.findById(idLocalizacion)
                    .orElseThrow(() -> new RuntimeException("Localización no encontrada con ID: " + idLocalizacion));
            notificacion.setLocalizacion(localizacion);
        }

        notificacion.setFechaEnvio(LocalDateTime.now());

        if (notificacion.getEstadoLectura() == null || notificacion.getEstadoLectura().isBlank()) {
            notificacion.setEstadoLectura("no leida");
        }

        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizar(Integer id, Notificacion datosActualizados) {
        Notificacion notificacion = obtenerPorId(id);

        notificacion.setTitulo(datosActualizados.getTitulo());
        notificacion.setMensaje(datosActualizados.getMensaje());
        notificacion.setTipoAlerta(datosActualizados.getTipoAlerta());
        notificacion.setNivelRiesgo(datosActualizados.getNivelRiesgo());
        notificacion.setEstadoLectura(datosActualizados.getEstadoLectura());

        return notificacionRepository.save(notificacion);
    }

    public Notificacion marcarComoLeida(Integer id) {
        Notificacion notificacion = obtenerPorId(id);
        notificacion.setEstadoLectura("leida");
        return notificacionRepository.save(notificacion);
    }

    public void eliminar(Integer id) {
        Notificacion notificacion = obtenerPorId(id);
        notificacionRepository.delete(notificacion);
    }
}

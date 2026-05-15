package com.surftracker.service;

import com.surftracker.entity.Favorito;
import com.surftracker.entity.Localizacion;
import com.surftracker.entity.Usuario;
import com.surftracker.repository.FavoritoRepository;
import com.surftracker.repository.LocalizacionRepository;
import com.surftracker.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FavoritoService {

    private final FavoritoRepository favoritoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LocalizacionRepository localizacionRepository;

    public FavoritoService(
            FavoritoRepository favoritoRepository,
            UsuarioRepository usuarioRepository,
            LocalizacionRepository localizacionRepository
    ) {
        this.favoritoRepository = favoritoRepository;
        this.usuarioRepository = usuarioRepository;
        this.localizacionRepository = localizacionRepository;
    }

    public List<Favorito> listar() {
        return favoritoRepository.findAll();
    }

    public Favorito obtenerPorId(Integer id) {
        return favoritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favorito no encontrado con ID: " + id));
    }

    public List<Favorito> listarPorUsuario(Integer idUsuario) {
        return favoritoRepository.findByUsuarioIdUsuario(idUsuario);
    }

    public List<Favorito> listarPorLocalizacion(Integer idLocalizacion) {
        return favoritoRepository.findByLocalizacion_Id(idLocalizacion);
    }

    public Favorito guardar(Favorito favorito) {
        if (favorito.getUsuario() == null || favorito.getUsuario().getIdUsuario() == null) {
            throw new RuntimeException("El usuario es obligatorio");
        }
        if (favorito.getLocalizacion() == null || favorito.getLocalizacion().getId() == null) {
            throw new RuntimeException("La localización es obligatoria");
        }

        Usuario usuario = usuarioRepository.findById(favorito.getUsuario().getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + favorito.getUsuario().getIdUsuario()));

        Localizacion localizacion = localizacionRepository.findById(favorito.getLocalizacion().getId())
                .orElseThrow(() -> new RuntimeException("Localización no encontrada con ID: " + favorito.getLocalizacion().getId()));

        favorito.setUsuario(usuario);
        favorito.setLocalizacion(localizacion);
        favorito.setFechaAgregado(LocalDate.now());

        return favoritoRepository.save(favorito);
    }

    public void eliminar(Integer id) {
        Favorito favorito = obtenerPorId(id);
        favoritoRepository.delete(favorito);
    }
}

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

    public Favorito guardar(Integer idUsuario, Integer idLocalizacion) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

        Localizacion localizacion = localizacionRepository.findById(idLocalizacion)
                .orElseThrow(() -> new RuntimeException("Localización no encontrada con ID: " + idLocalizacion));

        Favorito favorito = new Favorito();
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

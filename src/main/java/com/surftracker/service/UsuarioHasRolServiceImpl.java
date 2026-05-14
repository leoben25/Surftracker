package com.surftracker.service;

import com.surftracker.entity.UsuarioHasRol;
import com.surftracker.repository.UsuarioHasRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioHasRolServiceImpl implements UsuarioHasRolService {

    @Autowired
    private UsuarioHasRolRepository usuarioHasRolRepository;

    @Override
    public List<UsuarioHasRol> listarTodos() {
        return usuarioHasRolRepository.findAll();
    }

    @Override
    public Optional<UsuarioHasRol> obtenerPorId(Integer id) {
        return usuarioHasRolRepository.findById(id);
    }

    @Override
    public List<UsuarioHasRol> listarPorUsuario(Integer idUsuario) {
        return usuarioHasRolRepository.findByUsuario_IdUsuario(idUsuario);
    }

    @Override
    public UsuarioHasRol guardar(UsuarioHasRol usuarioHasRol) {
        return usuarioHasRolRepository.save(usuarioHasRol);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioHasRolRepository.deleteById(id);
    }
}
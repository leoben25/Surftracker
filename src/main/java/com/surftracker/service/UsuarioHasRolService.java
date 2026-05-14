package com.surftracker.service;

import com.surftracker.entity.UsuarioHasRol;
import java.util.List;
import java.util.Optional;

public interface UsuarioHasRolService {

    List<UsuarioHasRol> listarTodos();

    Optional<UsuarioHasRol> obtenerPorId(Integer id);

    List<UsuarioHasRol> listarPorUsuario(Integer idUsuario);

    UsuarioHasRol guardar(UsuarioHasRol usuarioHasRol);

    void eliminar(Integer id);
}
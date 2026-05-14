package com.surftracker.service;

import com.surftracker.entity.RolHasOpcion;
import java.util.List;
import java.util.Optional;

public interface RolHasOpcionService {

    List<RolHasOpcion> listarTodos();

    Optional<RolHasOpcion> obtenerPorId(Integer id);

    List<RolHasOpcion> listarPorRol(Integer idRol);

    RolHasOpcion guardar(RolHasOpcion rolHasOpcion);

    void eliminar(Integer id);
}
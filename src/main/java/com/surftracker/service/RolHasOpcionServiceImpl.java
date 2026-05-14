package com.surftracker.service;

import com.surftracker.entity.RolHasOpcion;
import com.surftracker.repository.RolHasOpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolHasOpcionServiceImpl implements RolHasOpcionService {

    @Autowired
    private RolHasOpcionRepository rolHasOpcionRepository;

    @Override
    public List<RolHasOpcion> listarTodos() {
        return rolHasOpcionRepository.findAll();
    }

    @Override
    public Optional<RolHasOpcion> obtenerPorId(Integer id) {
        return rolHasOpcionRepository.findById(id);
    }

    @Override
    public List<RolHasOpcion> listarPorRol(Integer idRol) {
        return rolHasOpcionRepository.findByRol_IdRol(idRol);
    }

    @Override
    public RolHasOpcion guardar(RolHasOpcion rolHasOpcion) {
        return rolHasOpcionRepository.save(rolHasOpcion);
    }

    @Override
    public void eliminar(Integer id) {
        rolHasOpcionRepository.deleteById(id);
    }
}
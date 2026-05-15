package com.surftracker.service;

import com.surftracker.entity.Localizacion;
import java.util.List;

public interface LocalizacionService {

    Localizacion registrar(Localizacion localizacion);

    List<Localizacion> listar();

    Localizacion buscarPorId(Integer id);

    Localizacion actualizar(Localizacion localizacion);

    void eliminar(Integer id);

}

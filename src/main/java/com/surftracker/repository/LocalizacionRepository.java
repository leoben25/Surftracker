package com.surftracker.repository;
import com.surftracker.entity.Localizacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalizacionRepository extends JpaRepository<Localizacion,Integer> {


    List<Localizacion> findByDistrito(String distrito);

    List<Localizacion> findByProvincia(String provincia);

    List<Localizacion> findByNombrePlayaContaining(String nombre);

}

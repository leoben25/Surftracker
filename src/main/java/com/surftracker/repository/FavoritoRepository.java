package com.surftracker.repository;

import com.surftracker.entity.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {

    List<Favorito> findByUsuarioIdUsuario(Integer idUsuario);

    List<Favorito> findByLocalizacion_Id(Integer idLocalizacion);
}

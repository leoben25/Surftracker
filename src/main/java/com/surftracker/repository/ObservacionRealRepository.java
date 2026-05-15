package com.surftracker.repository;

import com.surftracker.entity.ObservacionReal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ObservacionRealRepository extends JpaRepository<ObservacionReal,Integer> {


    List<ObservacionReal>
    findByFechaObservacion(Date fecha);


    List<ObservacionReal>
    findByTemperaturaRealGreaterThan(Double temp);


}
package com.surftracker.repository;

import com.surftracker.entity.ConsultaPronostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaPronosticoRepository extends JpaRepository<ConsultaPronostico,Integer> {


    List<ConsultaPronostico>
    findByIdUsuario(Integer usuario);

}

package com.surftracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pronostico")
public class Pronostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPronostico;

    private int idLocalizacion;
    private LocalDateTime fechaGeneracion;
    private LocalDate fechaPronostico;
    private double temperatura;
    private double alturaOlas;
    private double periodoOlas;
    private String direccionOlas;
    private double velocidadViento;
    private String direccionViento;
    private double humedad;
    private double lluvia;
    private double nubosidad;
    private double radiacionSolar;
}
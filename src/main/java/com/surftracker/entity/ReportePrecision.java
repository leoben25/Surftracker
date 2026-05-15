package com.surftracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reporte_precision")
public class ReportePrecision {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private int idReporte;

    @ManyToOne
    @JoinColumn(name = "id_observacion")
    private ObservacionReal observacion;

    @Column(name = "porcentaje_precision")
    private double porcentajePrecision;

    @Column(name = "diferencia")
    private double diferencia;

    @Column(name = "fecha_reporte")
    private LocalDate fechaReporte;

    @ManyToOne
    @JoinColumn(name = "id_pronostico")
    private Pronostico pronostico;
}
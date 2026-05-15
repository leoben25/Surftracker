package com.surftracker.service;

import com.surftracker.entity.ReportePrecision;

import java.time.LocalDate;
import java.util.List;

public interface  ReportePrecisionService{

    public abstract ReportePrecision inserta(ReportePrecision reporte);
    public abstract List<ReportePrecision> listaTodos();
    public abstract List<ReportePrecision> listaPorFechaReporte(LocalDate fecha);
    public abstract List<ReportePrecision> listaPorMinimaPrecision(double precisionMinima);
    public abstract List<ReportePrecision> listaPorPronostico(int idPronostico);

}
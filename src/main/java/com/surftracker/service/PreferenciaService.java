package com.surftracker.service;



import com.surftracker.entity.Preferencia;

import java.util.List;

public interface PreferenciaService {

    public abstract Preferencia inserta(Preferencia preferencia);
    public abstract List<Preferencia> listaTodos();
    public abstract List<Preferencia> listaPorUsuario(int idUsuario);
    public abstract List<Preferencia> listaPorTema(String tema);
    public abstract List<Preferencia> listaPorNotificacionesActivas(boolean recibirAlertas);

}
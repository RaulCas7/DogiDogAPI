package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Notificacion;
import org.example.dogidogapi.model.Usuario;

import java.util.List;

public interface NotificacionService {
    List<Notificacion> findAll();
    Notificacion findById(Integer id);
    Notificacion guardar(Notificacion notificacion);
    Notificacion actualizar(Notificacion nueva, Integer id);
    Notificacion eliminar(Integer id);
    List<Notificacion> buscarNotificacionesPorUsuario(Usuario usuario);
}

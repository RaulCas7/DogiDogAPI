package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Documentacion;
import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.Notificacion;
import org.example.dogidogapi.model.Usuario;

import java.util.List;

public interface DocumentacionService {
    List<Documentacion> findAll();
    Documentacion findById(Integer id);
    Documentacion guardar(Documentacion documentacion);
    Documentacion actualizar(Documentacion nuevo, Integer id);
    Documentacion eliminar(Integer id);
    List<Documentacion> buscarDocumentosPorMascota(Mascota mascota);
}

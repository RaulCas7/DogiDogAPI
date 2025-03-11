package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Documentacion;

import java.util.List;

public interface DocumentacionService {
    List<Documentacion> findAll();
    Documentacion findById(Integer id);
    Documentacion guardar(Documentacion documentacion);
    Documentacion actualizar(Documentacion nuevo, Integer id);
    Documentacion eliminar(Integer id);

}

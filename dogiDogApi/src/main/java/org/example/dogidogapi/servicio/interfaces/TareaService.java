package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> findAll();
    Tarea findById(Integer id);
    Tarea guardar(Tarea tarea);
    Tarea actualizar(Tarea nueva, Integer id);
    Tarea eliminar(Integer id);
}



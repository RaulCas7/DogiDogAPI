package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.ComentarioTarea;

import java.util.List;

public interface ComentarioTareaService {
    List<ComentarioTarea> findAll();
    ComentarioTarea findById(Integer id);
    ComentarioTarea guardar(ComentarioTarea comentario);
    ComentarioTarea actualizar(ComentarioTarea nuevo, Integer id);
    ComentarioTarea eliminar(Integer id);
}


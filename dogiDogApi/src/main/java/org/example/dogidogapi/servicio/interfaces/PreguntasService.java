package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Pregunta;

import java.util.List;

public interface PreguntasService {
    List<Pregunta> findAll();
    Pregunta findById(Integer id);
    Pregunta guardar(Pregunta pregunta);
    Pregunta actualizar(Pregunta nueva, Integer id);
    Pregunta eliminar(Integer id);
    Pregunta buscarPorPregunta(String pregunta);
}

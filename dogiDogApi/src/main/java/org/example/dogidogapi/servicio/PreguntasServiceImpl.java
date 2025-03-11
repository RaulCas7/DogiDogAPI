package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Pregunta;
import org.example.dogidogapi.repository.PreguntasRepository;
import org.example.dogidogapi.servicio.interfaces.PreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntasServiceImpl implements PreguntasService {
    @Autowired
    PreguntasRepository preguntasRepository;

    @Override
    public List<Pregunta> findAll() {
        return preguntasRepository.findAll();
    }

    @Override
    public Pregunta findById(Integer id) {
        return preguntasRepository.findById(id).orElse(null);
    }

    @Override
    public Pregunta guardar(Pregunta pregunta) {
        return preguntasRepository.save(pregunta);
    }

    @Override
    public Pregunta actualizar(Pregunta nueva, Integer id) {
        if (preguntasRepository.existsById(id)) {
            nueva.setId(id);
            return preguntasRepository.save(nueva);
        }else {
            return null;
        }
    }

    @Override
    public Pregunta eliminar(Integer id) {
        if (preguntasRepository.existsById(id)) {
            Pregunta pregunta = preguntasRepository.findById(id).get();
            preguntasRepository.delete(pregunta);
            return pregunta;
        }else {
            return null;
        }
    }
}

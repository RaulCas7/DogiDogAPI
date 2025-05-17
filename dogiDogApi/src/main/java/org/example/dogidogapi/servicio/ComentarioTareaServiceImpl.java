package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.ComentarioTarea;
import org.example.dogidogapi.repository.ComentarioTareaRepository;
import org.example.dogidogapi.servicio.interfaces.ComentarioTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioTareaServiceImpl implements ComentarioTareaService {

    @Autowired
    private ComentarioTareaRepository comentarioTareaRepository;

    @Override
    public List<ComentarioTarea> findAll() {
        return comentarioTareaRepository.findAll();
    }

    @Override
    public ComentarioTarea findById(Integer id) {
        return comentarioTareaRepository.findById(id).orElse(null);
    }

    @Override
    public ComentarioTarea guardar(ComentarioTarea comentario) {
        return comentarioTareaRepository.save(comentario);
    }

    @Override
    public ComentarioTarea actualizar(ComentarioTarea nuevo, Integer id) {
        ComentarioTarea existente = comentarioTareaRepository.findById(id).orElse(null);
        if (existente != null) {
            nuevo.setId(id);
            return comentarioTareaRepository.save(nuevo);
        } else {
            return null;
        }
    }

    @Override
    public ComentarioTarea eliminar(Integer id) {
        if (comentarioTareaRepository.existsById(id)) {
            ComentarioTarea comentario = comentarioTareaRepository.findById(id).get();
            comentarioTareaRepository.delete(comentario);
            return comentario;
        } else {
            return null;
        }
    }
}

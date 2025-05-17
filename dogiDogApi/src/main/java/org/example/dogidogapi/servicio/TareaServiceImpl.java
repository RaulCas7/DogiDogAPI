package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Tarea;
import org.example.dogidogapi.repository.TareaRepository;
import org.example.dogidogapi.servicio.interfaces.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea findById(Integer id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea actualizar(Tarea nueva, Integer id) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        if (tarea != null) {
            nueva.setId(id);
            return tareaRepository.save(nueva);
        } else {
            return null;
        }
    }

    @Override
    public Tarea eliminar(Integer id) {
        if (tareaRepository.existsById(id)) {
            Tarea tarea = tareaRepository.findById(id).get();
            tareaRepository.delete(tarea);
            return tarea;
        } else {
            return null;
        }
    }
}

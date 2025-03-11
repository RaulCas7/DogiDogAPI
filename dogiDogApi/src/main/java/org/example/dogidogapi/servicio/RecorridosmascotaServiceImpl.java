package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Recorrido;
import org.example.dogidogapi.repository.RecorridosmascotaRepository;
import org.example.dogidogapi.servicio.interfaces.RecorridosmascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecorridosmascotaServiceImpl implements RecorridosmascotaService {

    @Autowired
    private RecorridosmascotaRepository recorridosmascotaRepository;

    @Override
    public List<Recorrido> findAll() {
        return recorridosmascotaRepository.findAll();
    }

    @Override
    public Recorrido findById(Integer id) {
        return recorridosmascotaRepository.findById(id).orElse(null);
    }

    @Override
    public Recorrido guardar(Recorrido recorrido) {
        return recorridosmascotaRepository.save(recorrido);
    }

    @Override
    public Recorrido actualizar(Recorrido nueva, Integer id) {
        if(recorridosmascotaRepository.existsById(id)) {
            nueva.setId(id);
            return recorridosmascotaRepository.save(nueva);
        }else {
            return null;
        }
    }

    @Override
    public Recorrido eliminar(Integer id) {
        if(recorridosmascotaRepository.existsById(id)) {
            Recorrido recorrido = recorridosmascotaRepository.findById(id).get();
            recorridosmascotaRepository.deleteById(id);
            return recorrido;
        }else {
            return null;
        }
    }
}

package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Logro;
import org.example.dogidogapi.repository.LogroRepository;
import org.example.dogidogapi.servicio.interfaces.LogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogroServiceImpl implements LogroService {

    @Autowired
    private LogroRepository logroRepository;

    @Override
    public List<Logro> findAll() {
        return logroRepository.findAll();
    }

    @Override
    public Logro findById(Integer id) {
        return logroRepository.findById(id).orElse(null);
    }

    @Override
    public Logro guardar(Logro logro) {
        return logroRepository.save(logro);
    }

    @Override
    public Logro actualizar(Logro nuevo, Integer id) {
        Logro actual = logroRepository.findById(id).orElse(null);
        if (actual != null) {
            nuevo.setId(id);
            return logroRepository.save(nuevo);
        }else{
            return null;
        }
    }

    @Override
    public Logro eliminar(Integer id) {
        return null;
    }
}

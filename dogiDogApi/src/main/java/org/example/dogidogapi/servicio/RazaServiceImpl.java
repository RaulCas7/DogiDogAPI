package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Raza;
import org.example.dogidogapi.repository.RazaRepository;
import org.example.dogidogapi.servicio.interfaces.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RazaServiceImpl implements RazaService {

    @Autowired
    private RazaRepository razaRepository;

    @Override
    public List<Raza> findAll() {
        return razaRepository.findAll();
    }

    @Override
    public Raza findById(Integer id) {
        return razaRepository.findById(id).orElse(null);
    }

    @Override
    public Raza guardar(Raza raza) {
        return razaRepository.save(raza);
    }

    @Override
    public Raza actualizar(Raza nueva, Integer id) {
        if(razaRepository.existsById(id)) {
            nueva.setId(id);
            return razaRepository.save(nueva);
        }else{
            return null;
        }
    }

    @Override
    public Raza eliminar(Integer id) {
        if(razaRepository.existsById(id)) {
            Raza raza = razaRepository.findById(id).get();
            razaRepository.delete(raza);
            return raza;
        }else{
            return null;
        }
    }
}

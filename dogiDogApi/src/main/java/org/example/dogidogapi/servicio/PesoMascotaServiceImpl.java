package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.PesoMascota;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.repository.MascotaRepository;
import org.example.dogidogapi.repository.PesoMascotaRepository;
import org.example.dogidogapi.servicio.interfaces.MascotaService;
import org.example.dogidogapi.servicio.interfaces.PesoMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesoMascotaServiceImpl implements PesoMascotaService {
    @Autowired
    private PesoMascotaRepository pesoMascotaRepository;

    @Override
    public List<PesoMascota> findAll() {
        return pesoMascotaRepository.findAll();
    }

    @Override
    public PesoMascota findById(Integer id) {
        return pesoMascotaRepository.findById(id).orElse(null);
    }

    @Override
    public PesoMascota guardar(PesoMascota mascota) {
        return pesoMascotaRepository.save(mascota);
    }

    @Override
    public PesoMascota actualizar(PesoMascota nueva, Integer id) {
        if(pesoMascotaRepository.existsById(id)){
            nueva.setId(id);
            return pesoMascotaRepository.save(nueva);
        }else {
            return null;
        }
    }

    @Override
    public PesoMascota eliminar(Integer id) {
        if(pesoMascotaRepository.existsById(id)){
            PesoMascota pesoMascota = pesoMascotaRepository.findById(id).get();
            pesoMascotaRepository.deleteById(id);
            return pesoMascota;
        }else{
            return null;
        }
    }

    @Override
    public List<PesoMascota> findByMascota(Mascota mascota) {
        return pesoMascotaRepository.findByMascota(mascota);
    }
}

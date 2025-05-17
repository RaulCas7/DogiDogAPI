package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.repository.MascotaRepository;
import org.example.dogidogapi.servicio.interfaces.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota findById(Integer id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota actualizar(Mascota nueva, Integer id) {
        if(mascotaRepository.existsById(id)){
            nueva.setId(id);
            return mascotaRepository.save(nueva);
        }else {
            return null;
        }
    }

    @Override
    public Mascota eliminar(Integer id) {
        if(mascotaRepository.existsById(id)){
            Mascota mascota = mascotaRepository.findById(id).get();
            mascotaRepository.deleteById(id);
            return mascota;
        }else{
            return null;
        }
    }

    @Override
    public List<Mascota> findByUsuario(Usuario usuario) {
        return mascotaRepository.findByUsuario(usuario);
    }
}

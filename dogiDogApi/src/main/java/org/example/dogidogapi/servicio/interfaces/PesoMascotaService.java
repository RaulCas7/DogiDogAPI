package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.PesoMascota;
import org.example.dogidogapi.model.Usuario;

import java.util.List;

public interface PesoMascotaService {
    List<PesoMascota> findAll();
    PesoMascota findById(Integer id);
    PesoMascota guardar(PesoMascota mascota);
    PesoMascota actualizar(PesoMascota nueva, Integer id);
    PesoMascota eliminar(Integer id);
    List<PesoMascota> findByMascota(Mascota mascota);
}

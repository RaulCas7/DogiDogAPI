package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.Usuario;

import java.util.List;

public interface MascotaService {
    List<Mascota> findAll();
    Mascota findById(Integer id);
    Mascota guardar(Mascota mascota);
    Mascota actualizar(Mascota nueva, Integer id);
    Mascota eliminar(Integer id);
    List<Mascota> findByUsuario(Usuario usuario);
}

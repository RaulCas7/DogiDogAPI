package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Raza;

import java.util.List;

public interface RazaService {
    List<Raza> findAll();
    Raza findById(Integer id);
    Raza guardar(Raza raza);
    Raza actualizar(Raza nueva, Integer id);
    Raza eliminar(Integer id);
}

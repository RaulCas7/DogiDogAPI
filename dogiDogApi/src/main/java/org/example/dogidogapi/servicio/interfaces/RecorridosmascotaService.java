package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Recorrido;

import java.util.List;

public interface RecorridosmascotaService {
    List<Recorrido> findAll();
    Recorrido findById(Integer id);
    Recorrido guardar(Recorrido recorrido);
    Recorrido actualizar(Recorrido nueva, Integer id);
    Recorrido eliminar(Integer id);
    List<Recorrido> findAllActivos();  // Obtener todos los recorridos activos
}

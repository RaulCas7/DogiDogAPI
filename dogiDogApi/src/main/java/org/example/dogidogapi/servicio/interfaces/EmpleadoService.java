package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Empleado;

import java.util.List;

public interface EmpleadoService {
    List<Empleado> findAll();
    Empleado findById(Integer id);
    Empleado guardar(Empleado empleado);
    Empleado actualizar(Empleado nuevo, Integer id);
    Empleado eliminar(Integer id);
}

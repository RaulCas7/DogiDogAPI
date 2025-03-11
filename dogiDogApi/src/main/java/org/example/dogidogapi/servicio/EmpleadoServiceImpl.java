package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Empleado;
import org.example.dogidogapi.repository.EmpleadoRepository;
import org.example.dogidogapi.servicio.interfaces.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findById(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado actualizar(Empleado nuevo, Integer id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            nuevo.setId(id);
            return empleadoRepository.save(nuevo);
        }else {
            return null;
        }
    }

    @Override
    public Empleado eliminar(Integer id) {
        if (empleadoRepository.existsById(id)) {
            Empleado empleado = empleadoRepository.findById(id).get();
            empleadoRepository.delete(empleado);
            return empleado;
        }else{
            return null;
        }
    }
}

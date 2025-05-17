package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Documentacion;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.model.Valoracion;
import org.example.dogidogapi.repository.ValoracionRepository;
import org.example.dogidogapi.servicio.interfaces.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionServiceImpl implements ValoracionService {



    @Autowired
    private ValoracionRepository valoracionRepository;

    @Override
    public List<Valoracion> findAll() {
        return valoracionRepository.findAll();
    }

    @Override
    public Valoracion findById(Integer id) {
        return valoracionRepository.findById(id).orElse(null);
    }


    @Override
    public Valoracion guardar(Valoracion valoracion) {
        return valoracionRepository.save(valoracion);
    }

    @Override
    public Valoracion actualizar(Valoracion nuevo, Integer id) {
        Valoracion valoracion = valoracionRepository.findById(id).orElse(null);
        if (valoracion != null) {
            nuevo.setId(id);
            return valoracionRepository.save(nuevo);
        } else {
            return null;
        }
    }

    @Override
    public Valoracion eliminar(Integer id) {
        if (valoracionRepository.existsById(id)) {
            Valoracion valoracion = valoracionRepository.findById(id).get();
            valoracionRepository.delete(valoracion);
            return valoracion;
        } else {
            return null;
        }
    }

    // Obtener todas las valoraciones de un usuario específico
    public List<Valoracion> obtenerValoracionesDeUsuario(Usuario usuario) {
        // Llamamos al repositorio para obtener todas las valoraciones donde el usuario fue valorado
        return valoracionRepository.findByValorado(usuario);
    }
}

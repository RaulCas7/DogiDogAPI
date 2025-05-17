package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Documentacion;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.model.Valoracion;

import java.util.List;

public interface ValoracionService {
    List<Valoracion> findAll();
    Valoracion findById(Integer id);
    Valoracion guardar(Valoracion valoracion);
    Valoracion actualizar(Valoracion nuevo, Integer id);
    Valoracion eliminar(Integer id);
    List<Valoracion> obtenerValoracionesDeUsuario(Usuario usuario);

}

package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Integer id);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Usuario nueva, Integer id);
    Usuario eliminar(Integer id);
}

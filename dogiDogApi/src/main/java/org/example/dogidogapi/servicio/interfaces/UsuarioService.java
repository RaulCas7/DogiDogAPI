package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Usuario;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Integer id);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Usuario nueva, Integer id);
    Usuario eliminar(Integer id);
    Usuario inicioSesion(String email, String password);
    Usuario verificarEmail(String email);
    Usuario actualizarCoordenadas(Integer id, Double latitud, Double longitud);
    Usuario terminarPaseo(Integer id);
}

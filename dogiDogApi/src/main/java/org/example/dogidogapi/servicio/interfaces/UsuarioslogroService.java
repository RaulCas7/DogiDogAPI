package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Usuarioslogro;
import org.example.dogidogapi.model.UsuarioslogroId;

import java.util.List;

public interface UsuarioslogroService {
    List<Usuarioslogro> findAll();
    Usuarioslogro findById(UsuarioslogroId id);
    Usuarioslogro guardar(Usuarioslogro usuarioslogro);
    Usuarioslogro actualizar(Usuarioslogro nueva, UsuarioslogroId id);
    Usuarioslogro eliminar(UsuarioslogroId id);
}

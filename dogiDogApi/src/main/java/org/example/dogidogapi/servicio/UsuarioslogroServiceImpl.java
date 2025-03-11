package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Usuarioslogro;
import org.example.dogidogapi.model.UsuarioslogroId;
import org.example.dogidogapi.repository.UsuarioslogroRepository;
import org.example.dogidogapi.servicio.interfaces.UsuarioslogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioslogroServiceImpl implements UsuarioslogroService {
    @Autowired
    private UsuarioslogroRepository usuarioslogroRepository;

    @Override
    public List<Usuarioslogro> findAll() {
        return usuarioslogroRepository.findAll();
    }

    @Override
    public Usuarioslogro findById(UsuarioslogroId id) {
        return usuarioslogroRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarioslogro guardar(Usuarioslogro usuarioslogro) {
        return usuarioslogroRepository.save(usuarioslogro);
    }

    @Override
    public Usuarioslogro actualizar(Usuarioslogro nueva, UsuarioslogroId id) {
        if(usuarioslogroRepository.existsById(id)){
            nueva.setId(id);
            return usuarioslogroRepository.save(nueva);
        }else{
            return null;
        }
    }

    @Override
    public Usuarioslogro eliminar(UsuarioslogroId id) {
        if (usuarioslogroRepository.existsById(id)){
            Usuarioslogro usuarioslogro = usuarioslogroRepository.findById(id).get();
            usuarioslogroRepository.delete(usuarioslogro);
            return usuarioslogro;
        }else {
            return null;
        }
    }
}

package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.repository.UsuarioRepository;
import org.example.dogidogapi.servicio.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
       return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Usuario nueva, Integer id) {
        if(usuarioRepository.existsById(id)) {
            nueva.setId(id);
            return usuarioRepository.save(nueva);
        }else{
            return null;
        }
    }

    @Override
    public Usuario eliminar(Integer id) {
        if(usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.findById(id).get();
            usuarioRepository.delete(usuario);
            return usuario;
        }else{
            return null;
        }
    }

    @Override
    public Usuario inicioSesion(String email, String password) {
        String md5Password = "";
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes(),0, password.length());
            md5Password = new BigInteger(1,messageDigest.digest()).toString(16);
            if (md5Password.length() < 32) {
                md5Password = "0" + md5Password;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return usuarioRepository.findUsuarioByEmailAndPassword(email, md5Password);
    }

    @Override
    public Usuario verificarEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email);
    }
}

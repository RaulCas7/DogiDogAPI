package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Notificacion;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.repository.NotificacionRepository;
import org.example.dogidogapi.repository.UsuarioRepository;
import org.example.dogidogapi.servicio.interfaces.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImpl implements NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;


    @Override
    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    @Override
    public Notificacion findById(Integer id) {
        return notificacionRepository.findById(id).orElse(null);
    }

    @Override
    public Notificacion guardar(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public Notificacion actualizar(Notificacion nueva, Integer id) {
        if(notificacionRepository.existsById(id)) {
            nueva.setId(id);
            return notificacionRepository.save(nueva);
        }else{
            return null;
        }
    }

    @Override
    public Notificacion eliminar(Integer id) {
        if(notificacionRepository.existsById(id)) {
            Notificacion notificacion = notificacionRepository.findById(id).get();
            notificacionRepository.deleteById(id);
            return notificacion;
        }else{
            return null;
        }
    }

    @Override
    public List<Notificacion> buscarNotificacionesPorUsuario(Usuario usuario) {
        return notificacionRepository.findByUsuario(usuario);
    }
}

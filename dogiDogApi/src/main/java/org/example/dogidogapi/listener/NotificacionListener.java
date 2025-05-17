package org.example.dogidogapi.listener;

import jakarta.persistence.PostPersist;
import org.example.dogidogapi.model.Notificacion;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.repository.UsuarioRepository;
import org.example.dogidogapi.servicio.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NotificacionListener {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    @PostPersist
    public void enviarCorreo(Notificacion notificacion) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(notificacion.getUsuario().getId());
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            String email = usuario.getEmail();
            String titulo = notificacion.getTitulo();
            String mensaje = notificacion.getMensaje();

            emailService.enviarCorreo(email, titulo, mensaje);
        }
    }
}

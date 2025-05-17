package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.Notificacion;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.servicio.interfaces.NotificacionService;
import org.example.dogidogapi.servicio.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Base de la URI
@RequestMapping("/dogidog")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/notificaciones")
    public ResponseEntity<?> obtenerTodasLasNotificaciones() {
        List<Notificacion> notificaciones = notificacionService.findAll();
        if (notificaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(notificaciones);
        }
    }

    @GetMapping("/notificaciones/{id}")
    public ResponseEntity<?> obtenerNotificacionPorId(@PathVariable int id) {
        Notificacion notificacion = notificacionService.findById(id);
        if (notificacion == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(notificacion);
        }
    }

    @PostMapping("/notificaciones")
    public ResponseEntity<?> guardarNotificacion(@RequestBody Notificacion notificacion) {
        notificacionService.guardar(notificacion);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/notificaciones/{id}")
    public ResponseEntity<?> actualizarNotificacion(@PathVariable int id, @RequestBody Notificacion notificacion) {
        Notificacion actual = notificacionService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(notificacionService.actualizar(notificacion,id));
        }
    }
    @DeleteMapping("/notificaciones/{id}")
    public ResponseEntity<?> eliminarNotificacion(@PathVariable int id) {
        Notificacion notificacion = notificacionService.findById(id);
        if (notificacion == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(notificacionService.eliminar(id));
        }
    }
    @GetMapping("/notificaciones/usuario")
    public ResponseEntity<?> obtenerLasNotificacionesDeUnUsuario(@RequestParam int usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);
        if(usuario == null) {
            return ResponseEntity.notFound().build();
        }else{
            List<Notificacion> notificaciones = notificacionService.buscarNotificacionesPorUsuario(usuario);
            if(notificaciones.isEmpty()) {
                return ResponseEntity.noContent().build();
            }else {
                return ResponseEntity.ok(notificaciones);
            }
        }
    }
}

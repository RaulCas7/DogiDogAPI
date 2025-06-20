package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.Raza;
import org.example.dogidogapi.model.Recorrido;
import org.example.dogidogapi.servicio.interfaces.MascotaService;
import org.example.dogidogapi.servicio.interfaces.RazaService;
import org.example.dogidogapi.servicio.interfaces.RecorridosmascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogidog")
public class RecorridosController {
    @Autowired
    private RecorridosmascotaService recorridosmascotaService;
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/recorridos")
    public ResponseEntity<?> obtenerTodosLosRecorridos() {
        List<Recorrido> recorridos = recorridosmascotaService.findAll();
        if (recorridos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(recorridos);
        }
    }

    @GetMapping("/recorridos/{id}")
    public ResponseEntity<?> obtenerRecorridoPorId(@PathVariable int id) {
        Recorrido recorrido = recorridosmascotaService.findById(id);
        if (recorrido == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(recorrido);
        }
    }
    @PostMapping("/recorridos")
    public ResponseEntity<?> guardarRecorrido(@RequestBody Recorrido recorrido) {
        // ¡OJO! Aquí está el truco
        Integer mascotaId = recorrido.getMascota().getId();

        Mascota mascota = mascotaService.findById(mascotaId);

        recorrido.setMascota(mascota); // aquí metes una mascota "persistente"

        Recorrido guardado = recorridosmascotaService.guardar(recorrido);
        return ResponseEntity.ok(guardado.getId());
    }

    @PutMapping("/recorridos/{id}")
    public ResponseEntity<?> actualizarRecorrido(@PathVariable int id, @RequestBody Recorrido recorrido) {
        Recorrido actual = recorridosmascotaService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(recorridosmascotaService.actualizar(recorrido,id));
        }
    }
    @DeleteMapping("/recorridos/{id}")
    public ResponseEntity<?> eliminarRecorrido(@PathVariable int id) {
        Recorrido recorrido = recorridosmascotaService.findById(id);
        if (recorrido == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(recorridosmascotaService.eliminar(id));
        }
    }

    @GetMapping("/recorridos/activos")
    public ResponseEntity<List<Recorrido>> obtenerRecorridosActivos() {
        List<Recorrido> recorridos = recorridosmascotaService.findAllActivos();
        return ResponseEntity.ok(recorridos);
    }
}

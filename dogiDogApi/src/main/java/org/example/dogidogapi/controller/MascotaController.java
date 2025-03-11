package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Logro;
import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.servicio.interfaces.LogroService;
import org.example.dogidogapi.servicio.interfaces.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Base de la URI
@RequestMapping("/dogidog")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/mascotas")
    public ResponseEntity<?> obtenerTodasLasMascotas() {
        List<Mascota> mascotas = mascotaService.findAll();
        if (mascotas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(mascotas);
        }
    }

    @GetMapping("/mascotas/{id}")
    public ResponseEntity<?> obtenerMascotaPorId(@PathVariable int id) {
        Mascota mascota = mascotaService.findById(id);
        if (mascota == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(mascota);
        }
    }

    @PostMapping("/mascotas")
    public ResponseEntity<?> guardarMascota(@RequestBody Mascota mascota) {
        mascotaService.guardar(mascota);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/mascotas/{id}")
    public ResponseEntity<?> actualizarMascota(@PathVariable int id, @RequestBody Mascota mascota) {
        Mascota actual = mascotaService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(mascotaService.actualizar(mascota,id));
        }
    }
    @DeleteMapping("/mascotas/{id}")
    public ResponseEntity<?> eliminarMascota(@PathVariable int id) {
        Mascota mascota = mascotaService.findById(id);
        if (mascota == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(mascotaService.eliminar(id));
        }
    }
}

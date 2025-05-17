package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.PesoMascota;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.servicio.interfaces.MascotaService;
import org.example.dogidogapi.servicio.interfaces.PesoMascotaService;
import org.example.dogidogapi.servicio.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Base de la URI
@RequestMapping("/dogidog")
public class PesoMascotaController {

    @Autowired
    private MascotaService mascotaService;
    @Autowired
    private PesoMascotaService pesoMascotaService;

    @GetMapping("/pesosmascota")
    public ResponseEntity<?> obtenerTodasLasMascotas() {
        List<PesoMascota> pesosMascotas = pesoMascotaService.findAll();
        if (pesosMascotas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(pesosMascotas);
        }
    }

    @GetMapping("/pesosmascota/{id}")
    public ResponseEntity<?> obtenerMascotaPorId(@PathVariable int id) {
        PesoMascota mascota = pesoMascotaService.findById(id);
        if (mascota == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(mascota);
        }
    }

    @PostMapping("/pesosmascota")
    public ResponseEntity<?> guardarMascota(@RequestBody PesoMascota peso) {
        pesoMascotaService.guardar(peso);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/pesosmascota/{id}")
    public ResponseEntity<?> actualizarMascota(@PathVariable int id, @RequestBody PesoMascota peso) {
        PesoMascota actual = pesoMascotaService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(pesoMascotaService.actualizar(peso,id));
        }
    }
    @DeleteMapping("/pesosmascota/{id}")
    public ResponseEntity<?> eliminarMascota(@PathVariable int id) {
        PesoMascota peso = pesoMascotaService.findById(id);
        if (peso == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(pesoMascotaService.eliminar(id));
        }
    }

    @GetMapping("/pesosmascota/mascota")
    public ResponseEntity<?> obtenerLosPesosDeUnaMascota(@RequestParam int mascotaId) {
        Mascota mascota = mascotaService.findById(mascotaId);
        if(mascota == null) {
            return ResponseEntity.notFound().build();
        }else{
            List<PesoMascota> pesosMascotas = pesoMascotaService.findByMascota(mascota);
            if(pesosMascotas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }else {
                return ResponseEntity.ok(pesosMascotas);
            }
        }
    }
}

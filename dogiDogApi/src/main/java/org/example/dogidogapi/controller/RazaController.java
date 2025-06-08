package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Pregunta;
import org.example.dogidogapi.model.Raza;
import org.example.dogidogapi.servicio.interfaces.PreguntasService;
import org.example.dogidogapi.servicio.interfaces.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogidog")
public class RazaController {
    @Autowired
    private RazaService razaService;

    @GetMapping("/razas")
    public ResponseEntity<?> obtenerTodasLasRazas() {
        List<Raza> razas = razaService.findAll();
        if (razas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(razas);
        }
    }

    @GetMapping("/razas/{id}")
    public ResponseEntity<?> obtenerRazaPorId(@PathVariable int id) {
        Raza raza = razaService.findById(id);
        if (raza == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(raza);
        }
    }

    @PostMapping("/razas")
    public ResponseEntity<?> guardarRaza(@RequestBody Raza raza) {
        raza.setId(null);
        razaService.guardar(raza);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/razas/{id}")
    public ResponseEntity<?> actualizarRaza(@PathVariable int id, @RequestBody Raza raza) {
        Raza actual = razaService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(razaService.actualizar(raza,id));
        }
    }
    @DeleteMapping("/razas/{id}")
    public ResponseEntity<?> eliminarRaza(@PathVariable int id) {
        Raza raza = razaService.findById(id);
        if (raza == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(razaService.eliminar(id));
        }
    }
}

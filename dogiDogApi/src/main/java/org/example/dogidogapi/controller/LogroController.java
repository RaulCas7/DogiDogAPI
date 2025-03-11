package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Logro;
import org.example.dogidogapi.servicio.interfaces.LogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Base de la URI
@RequestMapping("/dogidog")
public class LogroController {

    @Autowired
    private LogroService logroService;

    @GetMapping("/logros")
    public ResponseEntity<?> obtenerTodosLosLogros() {
        List<Logro> logros = logroService.findAll();
        if (logros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(logros);
        }
    }

    @GetMapping("/logros/{id}")
    public ResponseEntity<?> obtenerLogroPorId(@PathVariable int id) {
        Logro logro = logroService.findById(id);
        if (logro == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(logro);
        }
    }

    @PostMapping("/logros")
    public ResponseEntity<?> guardarLogro(@RequestBody Logro logro) {
        logroService.guardar(logro);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/logros/{id}")
    public ResponseEntity<?> actualizarLogro(@PathVariable int id, @RequestBody Logro logro) {
        Logro actual = logroService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(logroService.actualizar(logro,id));
        }
    }
    @DeleteMapping("/logros/{id}")
    public ResponseEntity<?> eliminarLogro(@PathVariable int id) {
        Logro logro = logroService.findById(id);
        if (logro == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(logroService.eliminar(id));
        }
    }
}

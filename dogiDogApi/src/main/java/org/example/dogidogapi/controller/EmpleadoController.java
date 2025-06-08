package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Empleado;
import org.example.dogidogapi.servicio.interfaces.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogidog")
public class EmpleadoController {

    @Autowired //Inyecta dependencias
    private EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public ResponseEntity<?> obtenerTodosEmpleados(){
        List<Empleado> empleados = empleadoService.findAll();
        if (empleados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(empleados);
        }
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<?> obtenerEmpleado(@PathVariable Integer id){
        Empleado empleado = empleadoService.findById(id);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(empleado);
        }
    }

    @PostMapping("/empleados")
    public ResponseEntity<?> guardarEmpleado(@RequestBody Empleado empleado){
        empleadoService.guardar(empleado);
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<?> actualizarEmpleado(@RequestBody Empleado empleado, @PathVariable Integer id){
        Empleado empleadoActual = empleadoService.findById(id);
        if (empleadoActual == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(empleadoService.actualizar(empleado,id));
        }
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Integer id){
        Empleado empleado = empleadoService.findById(id);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(empleadoService.eliminar(id));
        }
    }

    @GetMapping("/empleados/usuario/{usuarioId}")
    public ResponseEntity<?> obtenerEmpleadoPorUsuarioId(@PathVariable Integer usuarioId) {
        Empleado empleado = empleadoService.findByUsuarioId(usuarioId);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(empleado);
        }
    }
}

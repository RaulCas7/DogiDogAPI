package org.example.dogidogapi.controller;

import org.apache.commons.io.FilenameUtils;
import org.example.dogidogapi.model.Logro;
import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.servicio.interfaces.LogroService;
import org.example.dogidogapi.servicio.interfaces.MascotaService;
import org.example.dogidogapi.servicio.interfaces.UsuarioService;
import org.example.dogidogapi.servicio.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@RestController
//Base de la URI
@RequestMapping("/dogidog")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;
    @Autowired
    private UsuarioService usuarioService;

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
        return ResponseEntity.ok(mascota);
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

    @GetMapping("/mascotas/usuario")
    public ResponseEntity<?> obtenerLasMascotasDeUnUsuario(@RequestParam int usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);
        if(usuario == null) {
            return ResponseEntity.notFound().build();
        }else{
            List<Mascota> mascotas = mascotaService.findByUsuario(usuario);
            if(mascotas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }else {
                return ResponseEntity.ok(mascotas);
            }
        }
    }

    @PutMapping("/mascotas/{id}/foto")
    public ResponseEntity<String> guardarFotoMascota(@PathVariable("id") Integer id,
                                                     @RequestParam("fichero") MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado un archivo.");
        }

        String nombreArchivo = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        String uploadDir = "mascotas/" + id + "/foto/";

        // Eliminar y recrear el directorio
        File directory = new File(uploadDir);
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (!file.isDirectory()) file.delete();
            }
        } else {
            directory.mkdirs();
        }

        String extension = FilenameUtils.getExtension(nombreArchivo).toLowerCase();
        boolean esImagen = extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png");

        if (!esImagen) {
            return ResponseEntity.badRequest().body("El archivo debe ser una imagen JPG, JPEG o PNG.");
        }

        Mascota mascota = mascotaService.findById(id);
        if (mascota == null) {
            return ResponseEntity.badRequest().body("Mascota no encontrada.");
        }

        try {
            FileUploadUtil.guardarFichero(uploadDir, nombreArchivo, multipartFile);

            mascota.setFoto(nombreArchivo);
            mascotaService.guardar(mascota);

            return ResponseEntity.ok("Foto subida correctamente para la mascota con ID " + id);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al subir el archivo: " + e.getMessage());
        }
    }

    @GetMapping("/mascotas/{id}/foto")
    public ResponseEntity<Resource> getFotoMascota(@PathVariable("id") Integer id) {
        Mascota mascota = mascotaService.findById(id);

        if (mascota == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String nombreArchivo = mascota.getFoto();
        if (nombreArchivo == null || nombreArchivo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try {
            Path filePath = Paths.get("mascotas/" + id + "/foto/").resolve(nombreArchivo);
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}

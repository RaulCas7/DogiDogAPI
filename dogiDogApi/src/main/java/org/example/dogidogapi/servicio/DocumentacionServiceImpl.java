package org.example.dogidogapi.servicio;

import org.example.dogidogapi.model.Documentacion;
import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.repository.DocumentacionRepository;
import org.example.dogidogapi.servicio.interfaces.DocumentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentacionServiceImpl implements DocumentacionService {

    @Autowired
    private DocumentacionRepository documentacionRepository;


    @Override
    public List<Documentacion> findAll() {
        return documentacionRepository.findAll();
    }

    @Override
    public Documentacion findById(Integer id) {
        return documentacionRepository.findById(id).orElse(null);
    }

    @Override
    public Documentacion guardar(Documentacion documentacion) {
        return documentacionRepository.save(documentacion);
    }

    @Override
    public Documentacion actualizar(Documentacion nuevo, Integer id) {
        Documentacion documentacion = documentacionRepository.findById(id).orElse(null);
        if (documentacion != null) {
            nuevo.setId(id);
            return documentacionRepository.save(nuevo);
        }else{
            return null;
        }
    }

    @Override
    public Documentacion eliminar(Integer id) {
        if (documentacionRepository.existsById(id)) {
            Documentacion documentacion = documentacionRepository.findById(id).get();
            documentacionRepository.delete(documentacion);
            return documentacion;
        }else {
            return null;
        }
    }

    @Override
    public List<Documentacion> buscarDocumentosPorMascota(Mascota mascota) {
        return documentacionRepository.findByMascota(mascota);
    }
}

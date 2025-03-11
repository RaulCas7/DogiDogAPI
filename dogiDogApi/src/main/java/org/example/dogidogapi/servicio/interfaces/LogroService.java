package org.example.dogidogapi.servicio.interfaces;

import org.example.dogidogapi.model.Logro;

import java.util.List;

public interface LogroService {
    List<Logro> findAll();
    Logro findById(Integer id);
    Logro guardar(Logro logro);
    Logro actualizar(Logro nuevo, Integer id);
    Logro eliminar(Integer id);
}

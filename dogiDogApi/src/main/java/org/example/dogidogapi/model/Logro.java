package org.example.dogidogapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "logros")
public class Logro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logro_id", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "emblema")
    private String emblema;

    @ColumnDefault("0")
    @Column(name = "usuarios_desbloqueados")
    private Integer usuariosDesbloqueados;

    @OneToMany(mappedBy = "logro")
    private Set<Usuarioslogro> usuarioslogros = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmblema() {
        return emblema;
    }

    public void setEmblema(String emblema) {
        this.emblema = emblema;
    }

    public Integer getUsuariosDesbloqueados() {
        return usuariosDesbloqueados;
    }

    public void setUsuariosDesbloqueados(Integer usuariosDesbloqueados) {
        this.usuariosDesbloqueados = usuariosDesbloqueados;
    }

    public Set<Usuarioslogro> getUsuarioslogros() {
        return usuarioslogros;
    }

    public void setUsuarioslogros(Set<Usuarioslogro> usuarioslogros) {
        this.usuarioslogros = usuarioslogros;
    }

}
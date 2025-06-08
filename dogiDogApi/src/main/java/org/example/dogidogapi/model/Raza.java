package org.example.dogidogapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "razas")
public class Raza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "energia")
    private Byte energia;

    @Column(name = "inteligencia")
    private Byte inteligencia;

    @Column(name = "socializacion")
    private Byte socializacion;

    @Column(name = "cuidado")
    private Byte cuidado;

    @Column(name = "peso_min_macho", precision = 5, scale = 2)
    private BigDecimal pesoMinMacho;

    @Column(name = "peso_max_macho",  precision = 5, scale = 2)
    private BigDecimal pesoMaxMacho;

    @Column(name = "peso_min_hembra",  precision = 5, scale = 2)
    private BigDecimal pesoMinHembra;

    @Column(name = "peso_max_hembra",precision = 5, scale = 2)
    private BigDecimal pesoMaxHembra;

    @Column(name = "edad_maxima")
    private Integer edadMaxima;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Lob
    @Column(name = "dato_curioso")
    private String datoCurioso;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte getEnergia() {
        return energia;
    }

    public void setEnergia(Byte energia) {
        this.energia = energia;
    }

    public Byte getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Byte inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Byte getSocializacion() {
        return socializacion;
    }

    public void setSocializacion(Byte socializacion) {
        this.socializacion = socializacion;
    }

    public Byte getCuidado() {
        return cuidado;
    }

    public void setCuidado(Byte cuidado) {
        this.cuidado = cuidado;
    }

    public BigDecimal getPesoMinMacho() {
        return pesoMinMacho;
    }

    public void setPesoMinMacho(BigDecimal pesoMinMacho) {
        this.pesoMinMacho = pesoMinMacho;
    }

    public BigDecimal getPesoMaxMacho() {
        return pesoMaxMacho;
    }

    public void setPesoMaxMacho(BigDecimal pesoMaxMacho) {
        this.pesoMaxMacho = pesoMaxMacho;
    }

    public BigDecimal getPesoMinHembra() {
        return pesoMinHembra;
    }

    public void setPesoMinHembra(BigDecimal pesoMinHembra) {
        this.pesoMinHembra = pesoMinHembra;
    }

    public BigDecimal getPesoMaxHembra() {
        return pesoMaxHembra;
    }

    public void setPesoMaxHembra(BigDecimal pesoMaxHembra) {
        this.pesoMaxHembra = pesoMaxHembra;
    }

    public Integer getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(Integer edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDatoCurioso() {
        return datoCurioso;
    }

    public void setDatoCurioso(String datoCurioso) {
        this.datoCurioso = datoCurioso;
    }

}
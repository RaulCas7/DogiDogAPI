package org.example.dogidogapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "mascotas")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "raza_id", nullable = false)
    private Raza raza;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "peso", precision = 5, scale = 2)
    private BigDecimal peso;

    @Lob
    @Column(name = "genero")
    private String genero;

    @Column(name = "esterilizado")
    private Boolean esterilizado;

    @Column(name = "fecha_proxima_vacunacion")
    private LocalDate fechaProximaVacunacion;

    @Column(name = "fecha_proxima_desparasitacion")
    private LocalDate fechaProximaDesparasitacion;

    @Column(name = "foto")
    private String foto;

    @ColumnDefault("0")
    @Column(name = "metros_recorridos")
    private Long metrosRecorridos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(Boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public LocalDate getFechaProximaVacunacion() {
        return fechaProximaVacunacion;
    }

    public void setFechaProximaVacunacion(LocalDate fechaProximaVacunacion) {
        this.fechaProximaVacunacion = fechaProximaVacunacion;
    }

    public LocalDate getFechaProximaDesparasitacion() {
        return fechaProximaDesparasitacion;
    }

    public void setFechaProximaDesparasitacion(LocalDate fechaProximaDesparasitacion) {
        this.fechaProximaDesparasitacion = fechaProximaDesparasitacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getMetrosRecorridos() {
        return metrosRecorridos;
    }

    public void setMetrosRecorridos(Long metrosRecorridos) {
        this.metrosRecorridos = metrosRecorridos;
    }

}
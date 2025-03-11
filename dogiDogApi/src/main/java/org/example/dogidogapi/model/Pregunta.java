package org.example.dogidogapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "preguntasrespuestas")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pregunta_id", nullable = false)
    private Integer id;

    @Column(name = "pregunta", nullable = false)
    private String pregunta;

    @Lob
    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "audio_respuesta")
    private String audioRespuesta;

    @ColumnDefault("0")
    @Column(name = "contador_consultas")
    private Integer contadorConsultas;

    @Column(name = "fecha_ultima_consulta")
    private Instant fechaUltimaConsulta;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "creado_por")
    private Empleado creadoPor;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_creacion")
    private Instant fechaCreacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getAudioRespuesta() {
        return audioRespuesta;
    }

    public void setAudioRespuesta(String audioRespuesta) {
        this.audioRespuesta = audioRespuesta;
    }

    public Integer getContadorConsultas() {
        return contadorConsultas;
    }

    public void setContadorConsultas(Integer contadorConsultas) {
        this.contadorConsultas = contadorConsultas;
    }

    public Instant getFechaUltimaConsulta() {
        return fechaUltimaConsulta;
    }

    public void setFechaUltimaConsulta(Instant fechaUltimaConsulta) {
        this.fechaUltimaConsulta = fechaUltimaConsulta;
    }

    public Empleado getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Empleado creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
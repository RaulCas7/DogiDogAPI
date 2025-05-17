package org.example.dogidogapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "usuarioslogros")
public class Usuarioslogro {
    @EmbeddedId
    private UsuarioslogroId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logro_id", insertable = false, updatable = false)
    private Logro logro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_desbloqueo")
    private Instant fechaDesbloqueo;

    public UsuarioslogroId getId() {
        return id;
    }

    public void setId(UsuarioslogroId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Logro getLogro() {
        return logro;
    }

    public void setLogro(Logro logro) {
        this.logro = logro;
    }

    public Instant getFechaDesbloqueo() {
        return fechaDesbloqueo;
    }

    public void setFechaDesbloqueo(Instant fechaDesbloqueo) {
        this.fechaDesbloqueo = fechaDesbloqueo;
    }

}
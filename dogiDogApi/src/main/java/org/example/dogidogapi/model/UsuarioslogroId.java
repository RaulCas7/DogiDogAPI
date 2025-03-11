package org.example.dogidogapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioslogroId implements Serializable {
    private static final long serialVersionUID = 9130239187513647627L;
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "logro_id", nullable = false)
    private Integer logroId;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getLogroId() {
        return logroId;
    }

    public void setLogroId(Integer logroId) {
        this.logroId = logroId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioslogroId entity = (UsuarioslogroId) o;
        return Objects.equals(this.logroId, entity.logroId) &&
                Objects.equals(this.usuarioId, entity.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logroId, usuarioId);
    }

}
package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "puntuciaon")
public class Puntuacion extends EntidadPersistente {
    @ManyToOne
    @JoinColumn(name = "aporte_id", referencedColumnName = "id")
    private Aporte aporte;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "puntos")
    private int puntos;

    @Column(name = "fecha")
    private LocalDate fecha;

    public Puntuacion(int puntos, Usuario usuario){
        this.setUsuario(usuario);
        this.setPuntos(puntos);
        this.setFecha(LocalDate.now());
    }

    public Aporte getAporte() {
        return aporte;
    }

    public void setAporte(Aporte aporte) {
        this.aporte = aporte;
        aporte.agregarPuntuacion(this);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    private void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPuntos() {
        return puntos;
    }

    private void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    private void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
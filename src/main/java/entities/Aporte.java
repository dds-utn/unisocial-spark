package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aporte")
public class Aporte extends EntidadPersistente {
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "topico_id", referencedColumnName = "id")
    private Topico topico;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "aporte", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Puntuacion> puntuaciones;

    @OneToMany(mappedBy = "aporte", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Archivo> archivos;

    public Aporte(){
        this.puntuaciones = new ArrayList<>();
        this.archivos = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarPuntuacion(Puntuacion puntuacion){
        this.puntuaciones.add(puntuacion);
        this.usuario.recibirPuntuacionDeAporte(puntuacion);
    }

    public int sumatoriaDePuntuaciones(){
        return this.puntuaciones.stream().mapToInt(p -> p.getPuntos()).sum();
    }
}
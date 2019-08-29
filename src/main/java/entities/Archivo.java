package entities;

import javax.persistence.*;

@Entity
@Table(name = "archivo")
public class Archivo extends EntidadPersistente {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ruta")
    private String ruta;

    @ManyToOne
    @JoinColumn(name = "aporte_id", referencedColumnName = "id")
    private Aporte aporte;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
package entities;

import javax.persistence.*;

@Entity
@Table(name = "reputacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Reputacion extends EntidadPersistente {

    public void recibirPuntuacionDeAporte(Puntuacion puntuacion, Usuario usuario){}

    public void chanceParaAportar(Usuario usuario){}
}

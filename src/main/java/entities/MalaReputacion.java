package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mala")
public class MalaReputacion extends Reputacion {

    @Override
    public void chanceParaAportar(Usuario usuario){
        usuario.setReputacion(new BuenaReputacion());
    }
}

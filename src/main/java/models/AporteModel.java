package models;

import entities.Aporte;

import java.util.List;

public class AporteModel extends Model {
    private static AporteModel instance;

    public static AporteModel getInstance() {
        if(instance == null){
            instance = new AporteModel();
        }
        return instance;
    }

    public List<Aporte> buscarTodos(){
        return entityManager().createQuery("from Aporte").getResultList();
    }

    public Aporte buscar(int id){
        return entityManager().find(Aporte.class, id);
    }
}

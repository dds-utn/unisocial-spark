package models;

import db.EntityManagerHelper;
import entities.Rol;

import java.util.List;

public class RolModel extends Model {
    private static RolModel instance;

    public static RolModel getInstance() {
        if(instance == null){
            instance = new RolModel();
        }
        return instance;
    }

    private RolModel(){

    }

    @Override
    public List<Rol> buscarTodos() {
        return EntityManagerHelper.getEntityManager().createQuery("from Rol").getResultList();
    }

    @Override
    public Rol buscar(int id) {
        return EntityManagerHelper.getEntityManager().find(Rol.class, id);
    }
}

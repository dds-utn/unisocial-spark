package models;

import db.EntityManagerHelper;
import entities.Aporte;
import entities.Usuario;

import java.util.List;

public abstract class Model {
    public void agregar(Object object){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().persist(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    public void modificar(Object object){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().merge(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    public void eliminar(Object object){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().remove(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    public abstract <T> List<T> buscarTodos();

    public abstract <T> T buscar(int id);
}

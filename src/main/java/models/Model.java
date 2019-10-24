package models;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import java.util.List;

public abstract class Model implements WithGlobalEntityManager, TransactionalOps {
    public void agregar(Object object){
        withTransaction(() -> {
            entityManager().persist(object);
        });
    }

    public void modificar(Object object){
        withTransaction(() -> {
            entityManager().merge(object);
        });
    }

    public void eliminar(Object object){
        withTransaction(() -> {
            entityManager().remove(object);
        });
    }

    public abstract <T> List<T> buscarTodos();

    public abstract <T> T buscar(int id);
}

package repositories;

import entities.Rol;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioRol extends Repositorio {
    private static RepositorioRol instance;

    public static RepositorioRol getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioRol(dao);
        }
        return instance;
    }

    private RepositorioRol(DAO dao){
        this.setDao(dao);
    }

    public List<Rol> buscarTodos(){
        return this.dao.buscarTodos();
    }

    public Rol buscar(int id){
        return this.dao.buscar(id);
    }
}

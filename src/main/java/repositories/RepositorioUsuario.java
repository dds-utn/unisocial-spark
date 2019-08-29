package repositories;

import entities.Usuario;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioUsuario extends Repositorio {
    private static RepositorioUsuario instance;

    public static RepositorioUsuario getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioUsuario(dao);
        }
        return instance;
    }

    private RepositorioUsuario(DAO dao){
        this.setDao(dao);
    }

    public List<Usuario> buscarTodos(){
        return this.dao.buscarTodos();
    }

    public Usuario buscar(int id){
        return this.dao.buscar(id);
    }
}

package repositories;

import entities.Aporte;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioAporte extends Repositorio {

    public RepositorioAporte(DAO dao){
        this.setDao(dao);
    }

    public List<Aporte> buscarTodos(){
        return this.dao.buscarTodos(Aporte.class);
    }

    public Aporte buscar(int id){
        return this.dao.buscar(Aporte.class, id);
    }
}

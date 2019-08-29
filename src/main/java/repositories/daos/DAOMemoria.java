package repositories.daos;

import entities.EntidadPersistente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DAOMemoria implements DAO {
    private List<EntidadPersistente> entities;

    public DAOMemoria(List<EntidadPersistente> entidades){
        this.entities = entidades;
    }

    @Override
    public <T> List<T> buscarTodos() {
        return (List<T>) this.entities;
    }

    @Override
    public <T> T buscar(int id) {
        return (T) this.entities
                .stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public void agregar(Object unObjeto) {
        this.entities.add((EntidadPersistente)unObjeto);
    }

    @Override
    public void modificar(Object unObjeto) {

    }

    @Override
    public void eliminar(Object unObjeto) {
        this.entities.remove(unObjeto);
    }
}

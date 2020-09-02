package domain.repositories.daos;

import domain.repositories.BusquedaCondicional;

import java.util.List;

public interface DAO<T> {
    List<T> buscarTodos();
    T buscar(int id);
    T buscar(BusquedaCondicional condicional);
    void agregar(Object unObjeto);
    void modificar(Object unObjeto);
    void eliminar(Object unObjeto);
}

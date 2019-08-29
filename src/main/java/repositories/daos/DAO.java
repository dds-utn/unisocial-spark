package repositories.daos;

import java.util.List;

public interface DAO {
    public <T> List<T> buscarTodos();
    public <T> T buscar(int id);
    public void agregar(Object unObjeto);
    public void modificar(Object unObjeto);
    public void eliminar(Object unObjeto);
}

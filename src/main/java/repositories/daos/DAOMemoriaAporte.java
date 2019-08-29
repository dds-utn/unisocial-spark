package repositories.daos;

import entities.Aporte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DAOMemoriaAporte implements DAO {
    private List<Aporte> aportes;

    public DAOMemoriaAporte(){
        this.aportes = new ArrayList<>();
    }

    @Override
    public <T> List<T> buscarTodos(Class<T> clase) {
        return (List<T>) this.aportes;
    }

    @Override
    public <T> T buscar(Class<T> clase, int id) {
        return (T) this.aportes
                .stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public void agregar(Object unObjeto) {
        this.aportes.add((Aporte) unObjeto);
    }

    @Override
    public void modificar(Object unObjeto) {

    }

    @Override
    public void eliminar(Object unObjeto) {
        this.aportes.remove(unObjeto);
    }
}

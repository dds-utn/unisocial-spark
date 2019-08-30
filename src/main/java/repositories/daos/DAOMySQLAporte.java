package repositories.daos;

import entities.Aporte;
import models.AporteModel;

import java.util.List;

public class DAOMySQLAporte implements DAO {

    @Override
    public <T> List<T> buscarTodos() {
        return (List<T>) AporteModel.getInstance().buscarTodos();
    }

    @Override
    public <T> T buscar(int id) {
        return (T) AporteModel.getInstance().buscar(id);
    }

    @Override
    public void agregar(Object unObjeto) {
        AporteModel.getInstance().agregar(unObjeto);
    }

    @Override
    public void modificar(Object unObjeto) {
        AporteModel.getInstance().modificar(unObjeto);
    }

    @Override
    public void eliminar(Object unObjeto) {
        AporteModel.getInstance().eliminar(unObjeto);
    }
}

package repositories.daos;

import entities.Usuario;
import models.UsuarioModel;

import java.util.List;

public class DAOMySQLUsuario implements DAO {
    @Override
    public <T> List<T> buscarTodos() {
        return (List<T>) UsuarioModel.getInstance().buscarTodos();
    }

    @Override
    public <T> T buscar(int id) {
        return (T) UsuarioModel.getInstance().buscar(id);
    }

    @Override
    public void agregar(Object unObjeto) {
        UsuarioModel.getInstance().agregar(unObjeto);
    }

    @Override
    public void modificar(Object unObjeto) {
        UsuarioModel.getInstance().modificar(unObjeto);
    }

    @Override
    public void eliminar(Object unObjeto) {
        UsuarioModel.getInstance().eliminar(unObjeto);
    }
}

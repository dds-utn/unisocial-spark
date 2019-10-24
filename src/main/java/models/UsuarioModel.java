package models;

import entities.Usuario;

import java.util.List;

public class UsuarioModel extends Model {
    private static UsuarioModel instance;

    public static UsuarioModel getInstance() {
        if(instance == null){
            instance = new UsuarioModel();
        }
        return instance;
    }

    @Override
    public List<Usuario> buscarTodos(){
        return entityManager().createQuery("from Usuario").getResultList();
    }

    @Override
    public Usuario buscar(int id){
        return entityManager().find(Usuario.class, id);
    }

}

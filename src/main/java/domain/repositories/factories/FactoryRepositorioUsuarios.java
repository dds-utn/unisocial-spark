package domain.repositories.factories;

import config.Config;
import domain.entities.Usuario;
import domain.repositories.RepositorioDeUsuarios;
import domain.repositories.daos.DAO;
import domain.repositories.daos.DAOHibernate;
import domain.repositories.daos.DAOMemoria;
import domain.repositories.testMemoData.Data;

public class FactoryRepositorioUsuarios {
    private static RepositorioDeUsuarios repo;

    static {
        repo = null;
    }

    public static RepositorioDeUsuarios get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<Usuario> dao = new DAOHibernate<>(Usuario.class);
                repo = new RepositorioDeUsuarios(dao);
            }
            else{
                repo = new RepositorioDeUsuarios(new DAOMemoria<>(Data.getData(Usuario.class)));
            }
        }
        return repo;
    }
}

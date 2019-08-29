package repositories.factories;

import config.Config;
import models.UsuarioModel;
import repositories.RepositorioUsuario;
import repositories.daos.DAOMemoria;
import repositories.daos.DAOMySQL;
import repositories.testMemoData.DataUsuario;

public class FactoryRepositorioUsuario {
    private static RepositorioUsuario repo;

    public static RepositorioUsuario get(){
        if(repo == null){
            boolean useDataBase = Config.useDataBase;
            if(useDataBase){
                repo = RepositorioUsuario.getInstance(new DAOMySQL(UsuarioModel.getInstance()));
            }
            else{
                repo = RepositorioUsuario.getInstance(new DAOMemoria(DataUsuario.getList()));
            }
        }
        return repo;
    }
}

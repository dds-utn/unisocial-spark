package repositories.factories;

import config.Config;
import models.RolModel;
import repositories.RepositorioRol;
import repositories.daos.DAOMemoria;
import repositories.daos.DAOMySQL;
import repositories.testMemoData.DataRol;

public class FactoryRepositorioRol {
    private static RepositorioRol repo;

    public static RepositorioRol get(){
        if(repo == null){
            boolean useDataBase = Config.useDataBase;
            if(useDataBase){
                repo = RepositorioRol.getInstance(new DAOMySQL(RolModel.getInstance()));
            }
            else{
                repo = RepositorioRol.getInstance(new DAOMemoria(DataRol.getList()));
            }
        }
        return repo;
    }
}

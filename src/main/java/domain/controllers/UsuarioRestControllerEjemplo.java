package domain.controllers;

import com.google.gson.Gson;
import domain.entities.Usuario;
import domain.repositories.factories.FactoryRepositorio;
import spark.Request;
import spark.Response;

public class UsuarioRestControllerEjemplo {

    public String mostrar(Request request, Response response){
        Usuario usuario1 = FactoryRepositorio.get(Usuario.class).buscar(new Integer(request.params("id")));
        Gson gson = new Gson();
        String jsonUsuario = gson.toJson(usuario1);
        response.type("application/json");
        return jsonUsuario;
    }
}

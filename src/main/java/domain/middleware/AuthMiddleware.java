package domain.middleware;

import spark.Request;
import spark.Response;

public class AuthMiddleware {

    public Response verificarSesion(Request request, Response response){
        if(!request.session().isNew()){
            response.redirect("/usuarios");
        }
        return response;
    }
}

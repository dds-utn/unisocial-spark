package controllers;
import entities.Rol;
import entities.Usuario;
import repositories.RepositorioRol;
import repositories.RepositorioUsuario;
import repositories.factories.FactoryRepositorioRol;
import repositories.factories.FactoryRepositorioUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController {
    private RepositorioUsuario repo;

    public UsuarioController(){
        this.repo = FactoryRepositorioUsuario.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        List<Usuario> usuarios = this.repo.buscarTodos();
        parametros.put("usuarios", usuarios);
        return new ModelAndView(parametros, "usuarios.hbs");
    }

    public ModelAndView mostrar(Request request, Response response){
        Usuario usuario = this.repo.buscar(new Integer(request.params("id")));
        RepositorioRol repoRol = FactoryRepositorioRol.get();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", usuario);
        parametros.put("roles", repoRol.buscarTodos());
        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response modificar(Request request, Response response){
        Usuario usuario = this.repo.buscar(new Integer(request.params("id")));
        asignarAtributosA(usuario, request);
        this.repo.modificar(usuario);
        response.redirect("/usuarios");
        return response;
    }

    private void asignarAtributosA(Usuario usuario, Request request){
        if(request.queryParams("telefono") != null){
            int telefono = new Integer(request.queryParams("telefono"));
            usuario.setTelefono(telefono);
        }

        if(request.queryParams("nombre") != null){
            usuario.setNombre(request.queryParams("nombre"));
        }

        if(request.queryParams("email") != null){
            usuario.setEmail(request.queryParams("email"));
        }

        if(request.queryParams("nombreDeUsuario") != null){
            usuario.setNombreDeUsuario(request.queryParams("nombreDeUsuario"));
        }

        if(request.queryParams("apellido") != null){
            usuario.setApellido(request.queryParams("apellido"));
        }

        if(request.queryParams("legajo") != null){
            int legajo = new Integer(request.queryParams("legajo"));
            usuario.setLegajo(legajo);
        }

        if(request.queryParams("fechaDeNacimiento") != null && !request.queryParams("fechaDeNacimiento").isEmpty()){
            LocalDate fechaDeNacimiento = LocalDate.parse(request.queryParams("fechaDeNacimiento"));
            usuario.setFechaDeNacimiento(fechaDeNacimiento);
        }

        if(request.queryParams("rol") != null){
            RepositorioRol repoRol = FactoryRepositorioRol.get();
            Rol unRol = repoRol.buscar(new Integer(request.queryParams("rol")));
            usuario.setRol(unRol);
        }
    }

    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        RepositorioRol repoRol = FactoryRepositorioRol.get();

        parametros.put("roles", repoRol.buscarTodos());
        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response guardar(Request request, Response response){
        Usuario usuario = new Usuario();
        asignarAtributosA(usuario, request);
        this.repo.agregar(usuario);
        response.redirect("/usuarios");
        return response;
    }

    public Response eliminar(Request request, Response response){
        Usuario usuario = this.repo.buscar(new Integer(request.params("id")));
        this.repo.eliminar(usuario);
        return response;
    }
}

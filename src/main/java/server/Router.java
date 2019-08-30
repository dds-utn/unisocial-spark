package server;

import controllers.UsuarioController;
import models.UsuarioModel;
import repositories.daos.DAOMySQL;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        UsuarioController usuarioController = new UsuarioController();

        Spark.get("/usuarios", usuarioController::mostrarTodos, Router.engine);

        Spark.get("/usuario/:id", usuarioController::mostrar, Router.engine);

        Spark.get("/usuario", usuarioController::crear, Router.engine);

        Spark.post("/usuario/:id", usuarioController::modificar);

        Spark.post("/usuario", usuarioController::guardar);

        Spark.delete("/usuario/:id", usuarioController::eliminar);
    }
}

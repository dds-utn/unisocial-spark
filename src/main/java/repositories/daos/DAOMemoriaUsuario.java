package repositories.daos;

import entities.Permiso;
import entities.Rol;
import entities.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DAOMemoriaUsuario implements DAO {
    private List<Usuario> usuarios;

    public DAOMemoriaUsuario(){
        this.usuarios = new ArrayList<>();
        init();
    }

    private void init(){
        Rol admin = new Rol();
        admin.setNombre("Adminsitrador");

        Rol docente = new Rol();
        docente.setNombre("Docente");

        Rol alumno = new Rol();
        alumno.setNombre("Alumno");

        Usuario lucas = new Usuario();
        lucas.setNombre("Lucas");
        lucas.setApellido("Saclier");
        lucas.setId(1);
        lucas.setTelefono(1156585936);
        lucas.setLegajo(112233);
        lucas.setRol(admin);

        Usuario eze = new Usuario();
        eze.setNombre("Eze");
        eze.setApellido("Escobar");
        eze.setId(2);
        eze.setTelefono(1156339837);
        eze.setLegajo(112244);
        eze.setRol(docente);

        Usuario gaston = new Usuario();
        gaston.setNombre("Gaston");
        gaston.setApellido("Prieto");
        gaston.setId(3);
        gaston.setTelefono(1156449831);
        gaston.setLegajo(112255);
        gaston.setRol(docente);

        Usuario ezeS = new Usuario();
        ezeS.setNombre("Eze");
        ezeS.setApellido("Sosa");
        ezeS.setId(4);
        ezeS.setTelefono(1156559832);
        ezeS.setLegajo(112266);
        ezeS.setRol(docente);

        addAll(lucas, eze, gaston, ezeS);
    }

    private void addAll(Usuario ... usuario){
        Collections.addAll(this.usuarios, usuario);
    }

    @Override
    public <T> List<T> buscarTodos(Class<T> clase) {
        return (List<T>) this.usuarios;
    }

    @Override
    public <T> T buscar(Class<T> clase, int id) {
        return (T) this.usuarios
                .stream()
                .filter(u -> u.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public void agregar(Object unObjeto) {
        this.usuarios.add((Usuario) unObjeto);
    }

    @Override
    public void modificar(Object unObjeto) {

    }

    @Override
    public void eliminar(Object unObjeto) {
        this.usuarios.remove(unObjeto);
    }
}

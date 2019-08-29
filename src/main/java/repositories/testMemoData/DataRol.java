package repositories.testMemoData;

import entities.EntidadPersistente;
import entities.Rol;
import entities.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataRol {
    private static List<Rol> roles = new ArrayList<>();

    public static List<EntidadPersistente> getList(){
        if(roles.size() == 0){
            Rol admin = new Rol();
            admin.setNombre("Adminsitrador");
            admin.setId(1);

            Rol docente = new Rol();
            docente.setNombre("Docente");
            docente.setId(2);

            Rol alumno = new Rol();
            alumno.setNombre("Alumno");
            alumno.setId(3);

            addAll(admin, alumno, docente);
        }
        return (List<EntidadPersistente>)(List<?>)roles;
    }

    private static void addAll(Rol... roles){
        Collections.addAll(DataRol.roles, roles);
    }
}

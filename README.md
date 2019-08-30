# Unisocial - MVC - Spark
###  Dominio
Nos encargaremos de seguir resolviendo el dominio que comenzamos a atacar en el repositorio [Unisocial-Hibernate](https://github.com/dds-utn/unisocial-hibernate "Unisocial-Hibernate").

### ¿Qué es MVC?
Modelo-vista-controlador (MVC) es un patrón de arquitectura de software, que separa la arquitectura en tres componentes: el modelo, la vista y el controlador.

`El Modelo`: Está vinculado con la representación de la datos con la cual el sistema opera, por lo tanto gestiona todos los accesos a dichos datos, tanto consultas como actualizaciones, pudiendo también implementar los privilegios de acceso.

`El Controlador`: Responde a eventos (usualmente acciones del usuario) e invoca peticiones al 'modelo' cuando se hace alguna solicitud sobre los datos Se podría decir que el 'controlador' hace de intermediario entre la vista y el modelo.

`La Vista`: Presenta los datos y su forma de interactuar en un formato adecuado para el usuario.

![](https://miro.medium.com/max/1060/0*C5ykaWN2RzlbC47o.jpg)

### Cuestiones de persistencia
El diseño inicial planteado ofrece la posibilidad de trabajar con persistencia en memoria o en base de datos.
Para poder cambiar la forma de persistencia, se debe modificar el atributo `useDataBase` de la clase `Config` la cual se encuentra en el package Config:
- Con `useDataBase = true;` la persistencia se hará mediante base de datos. En este caso, ofrecemos una estructura inicial con datos de prueba. Esta estructura se encuentra en `scripts_sql/initial_database.sql` la cual debe ser importada desde algún cliente SQL, previamente habiendo creado un esquema/base de datos.  
Como seguimos los pasos y las bases planteadas en el repositorio anterior (Unisocial-Hibernate), se deberá tener instalado [MySQL Server 5.6](https://dev.mysql.com/downloads/mysql/5.6.html "MySQL Server 5.6") y [MySQL Workbench](https://dev.mysql.com/downloads/workbench/ "MySQL Workbench").
- Con `useDataBase = false;` la persistencia se hará en memoria. En este caso, brindamos algunas listas básicas para tener algunos objetos cargados en memoria. Estas listas se pueden encontrar en las clases que están en el package `testMemoData`, el cual, a su vez, se encuentra dentro del package `repositories`.

Para "jugar" con los objetos del dominio, diseñamos repositorios que entienden, básicamente, los mensajes:
1. `buscar(int id)` busca y devuelve el objeto que matchee con el id dado. Supone que siempre existe un objeto con ese id.
2. `buscarTodos()` busca y devuelve todos los objetos del repositorio en cuestión.
3. `agregar(Object unObjeto)` persiste un objeto en el medio persistente.
4. `modificar(Object unObjeto)` modifica un objeto en el medio persistente.
5. `eliminar(Object unObjeto)` elimina un objeto del medio persistente.

Pero... ¿cómo trabajamos con un repositorio? Supongamos que queremos buscar al Usuario de id 1. Podríamos hacer algo como:
```java
RepositorioUsuario repo = FactoryRepositorioUsuario.get();
Usuario usuario = repo.buscar(1);
```
### Vistas (HTML)
Dejamos a disposición dos maquetas:
1. *usuario.hbs*: es una vista que está pensada para mostrar el detalle de un usuario.
2. *usuarios.hbs*: es una vista que está pensada para mostrar el listado de todos los usuarios del sistema, así como también ejecutar acciones sobre ellos.

Estas vistas se encuentran en `src/resources/templates`

¿Y por qué la extensión no es *html*?
Porque utilizamos [Handlebars](https://handlebarsjs.com/builtin_helpers.html "Handlebars") que es un *template engine*, y los archivos de handlebars tienen extensión `.hbs`. Un template engine es un componente de software diseñado para combinar plantillas html con un conjunto de datos, produciendo un documento "combinado" como resultado.
### Estilos (CSS) y comportamiento de vistas (JS)
Dejamos a disposición una hoja de estilos y un archivo JavaScript, los cuales se usan en las vistas anteriormente mencionadas.
- Los archivos CSS se encuentran en `src/resources/public/css`
- Los archivos JS se encuentran en `src/resources/public/js`

Todos los archivos de estos tipos deberían situarse en estas carpetas para mantener la organización y prolijidad de todo el proyecto.
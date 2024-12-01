
# GestInmo Backend - Cómo ejecutar

Explicación de como ejecutar Gestinmo con fines académicos para realizar pentesting.



## Authors

- [@LuigiSalcedo](https://www.github.com/LuigiSalcedo)


## Environment Variables

Para configurar la aplicación entre la carpeta
src/main/resources y sobre el archivo application.properties encontrará las propiedades necesarias para la aplicación.

Debe contar con PostgreSQL en su máquina.

`spring.datasource.url` Cambie localhost por la dirección de la máquina con PostgreSQL (si es la misma que correra la aplicación no es necesario cambiarla) y gestinmo_db por el nombre de un base de datos vacía que tenga en la máquina (recomendamos crear una nueva con este nombre).

`spring.datasource.username` Cambie este valor por su usuario de PostgreSQL que maneje la base de datos creada. (No use comillas sólo escriba el nombre tal cual)

`spring.datasource.password` Análogo de el username pero con su contraseña de usuario.

`api.jwt.secret` Puede poner un texto cualquiera, tenga en cuenta que si utiliza un secret no seguro puede ser un problema de seguridad que no es directamente de la aplicación.




## Despliegue

Una vez haya configurado correctamente la variables de en archivo **application.properties** asegurese que en sus **variables de entorno de su máquina** tenga configurado la variable **JAVA_HOME** que debe apuntar a la carpeta de un **JDK de Java 17 o superior**. (Cierre la terminal y abra una nueva después de esto)

Una vez haya realizado esto con una terminal ubicada en el root del proyecto ejecute el siguiente comando:

```bash
./mvnw install
```

O en su defecto

```cmd
mvnw install
```
Esto debería comenzar la compilación del proyecto y generarle una carpeta target a nivel del root.

Seguido de este ejecute el siguiente comando
```bash
java -jar target/gestinmo-0.0.1-SNAPSHOT.jar
```

La aplicación ya debería comenzar su ejecución.

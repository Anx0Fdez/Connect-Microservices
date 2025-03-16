#  Pasos a seguir para crear y conectar dos microservicios.
### (PostgreSQL y MongoDB)


>[!Important]
> - Instalar MongoDB y PostgreSQL
> - Instalar MongoDB Compass

## Crear los proyectosd de los microservicios

1. Crear un proyecto de servicio de MongoDB con Spring Boot & Maven.
2. Java 23

### Dependencias de MongoDB:
- Spring Web
- Spring Data MongoDB
- Config Client

### Dependencias de PostgreSQL:
- Spring Web
- PostgreSQL Driver
- Spring Data JPA
- Config Client

# Servicio de MongoDB
## Pasos para crear el servicio de MongoDB

1. Metemeos manueal mente en el POM las dependencias de swagger
    ```xml
    <!-- Dependencia para Swagger -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.0.4</version>
    </dependency>
    ```
2. Modificamos el archivo application.properties para configurar la conexión a MongoDB y Swagger
3. Creamos los packages: config, controller, exceptions, model, repository, service

### Pasos para realizar el servicio:
1. Clases Config
2. Clase Properties
3. Clases Model
4. Clases Repository
5. Clases Service
6. Clases Controller


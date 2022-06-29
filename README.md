# Automatización De Pruebas La Aplicación RestApiExample

Automatización de pruebas de las diferentes interacciones (Crear, Consultar y Eliminar) que se púeden realizar con la información de los empleadosque en la aplicación RestApiExample.

## Herramientas implementadas
* Serenity BDD
* Serenity Rest
* Cucumber
* Junit

## Patrón de diseño
* Screenplay

## Lenguaje utilizado
* Java

## Gestor de dependencias
* Maven

## Instalación
* Tener el [JDK](https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html) Java Development Kit como minimo en la version 1.8
* Tener configurado [Maven](https://maven.apache.org/download.cgi) para la compilación del proyecto.
* Clonar el proyecto de su rama [master](https://github.com/dfmerchan2/DummyRestApiExample.git) ejecutando el siguiente comando

## Especificaciones del reto tecnico
* El ejercicio consta de poder realizar interacciones por medio de los Verbos comunes   que expone un Api rest y que puedas realizar todo el proceso que involucra   automatizar una de esas acciones necesarias para interactuar con Api.
* Anexo encontrarás un Api pública expuesta en internet que contiene los principales  verbos del Api (POST, GET, DELETE) , donde puedes realizar un flujo en este caso   para poder consultar empleados, crear empleados y eliminar registros, cabe resaltar   que dentro de la interacción que puedas realizar con los Endpoint expuestos es   necesario que realices validaciones sobre las respuestas que puedas obtener al   realizar cada una de las acciones.
* El stack técnico a utilizar (en la web hay varios ejemplos de proyectos de este tipo [Documetación Serenity](https://serenity-bdd.github.io/theserenitybook/latest/cucumber.html)) es:
  * Java 8 o mayor.
  * Maven para gestión de librerías.
  * Serenity BDD Screenplay.
  * Cucumber 4 o mayor con Serenity BDD.
  * Serenity Rest , Serenity BDD Screenplay
  * Hamcrest
* Crear un escenario de prueba por cada endpoint donde se haga algún tipo de   validación sobre la respuesta de la petición (body de la respuesta y status code de la respuesta).
  * [Servicio GET](http://dummy.restapiexample.com/api/v1/employees)
  * [Servicio POST](http://dummy.restapiexample.com/api/v1/create)
  * [Servicio GET](http://dummy.restapiexample.com/api/v1/employee/1)
  * [Servicio DELETE](http://dummy.restapiexample.com/api/v1/delete/2)
* Entrega
  * La entrega la puedes realizar publicando tu solución en un repositorio en github donde estaremos validando tu implementación dándole solución al ejercicio.
  * Posteriormente podrás sustentar tu implementación y aclarar dudas y discutir aspectos importantes en el proyecto realizado.
  * Page donde se puede encontrar toda la documentación de la API. [RestApiExample](http://dummy.restapiexample.com/)

## Autores
- Diego Fernando Merchan Jimenez
    
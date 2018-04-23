# Almundo.callcenter

callcenter.almundo.com, herramientas básicas de Java y diseño de soluciones orientadas a objetos.

Existe un call center donde hay 3 tipos de empleados: operador, supervisor
y director. El proceso de la atención de una llamada telefónica en primera
instancia debe ser atendida por un operador, si no hay ninguno libre debe
ser atendida por un supervisor, y de no haber tampoco supervisores libres
debe ser atendida por un director.

## Getting Started

### Requerimientos

* Debe existir una clase Dispatcher encargada de manejar las
llamadas, y debe contener el método dispatchCall para que las
asigne a los empleados disponibles.
* El método dispatchCall puede invocarse por varios hilos al mismo
tiempo.
* La clase Dispatcher debe tener la capacidad de poder procesar 10
llamadas al mismo tiempo (de modo concurrente).
* Cada llamada puede durar un tiempo aleatorio entre 5 y 10
segundos.
* Debe tener un test unitario donde lleguen 10 llamadas.

### Extras/Plus

* Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.
* Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes.
* Agregar los tests unitarios que se crean convenientes.
* Agregar documentación de código.

### Instalación

Construcción del artefacto Jar (callcenter-0.0.1.jar)

```
mvn clean install
```

## Corriendo los tests

Las pruebas están implementadas en Junit y TestNg

### Para ejecutar las pruebas ubicarse en el folder /almundo-call-center/callcenter

Ejecutar el siguiente comando:

```
mvn test
```

## Despliegue

Ubicarse en el folder /almundo-call-center/callcenter

```
java -jar target/callcenter-0.0.1.jar
```

### Link inicial de la aplicación

```
http://localhost:8085/index.html
```

## Construido con

* [SpringBoot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [SPRING INITIALIZR](https://start.spring.io/) - Bootstrap your application now

## Versión 0.0.1

## Autor

* **Jorge Romero** - *Ingeniero de sistemas* - [Linkedin](https://www.linkedin.com/in/jorge-luis-romero-casta%C3%B1eda-04791167/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Agradecimientos

* Almundo, por la oportunidad


# Ejemplo de uso de docx4j con spring boot para generación de archivos word 

Ejemplo de uso de la librería Java docx4j en una aplicación Spring Boot para generar un documento word en base a una plantilla de combinación por correspondencia.<p>
Esto podría permitir, por ejemplo, generar un listado de cartas a partir de un listado de personas en una base de datos.<p>
Para ilustrar un ejemplo se construye un método que recibe 6 parámetros de tipo string a través del método Post y produce como resultado un archivo docx que contiene dichos parámetros ingresados.
## Ejecución en local
  Requiere Java 8 instalado localmente para su ejecución. Una vez instalado clonar repositorio y ejecutar:
  ### Linux y Mac
```bash
./mvnw spring-boot:run
```
 ### Windows
```bash
mvnw spring-boot:run
```
## Uso
A través del método Post enviar un objeto de tipo Json con el siguiente formato a la url http://localhost:8070/api/v1/generar-carta:
```java
  {
  "ciudad": "string",
  "correo": "string",
  "destinatario": "string",
  "direccionDestinatario": "string",
  "direccionRemitente": "string",
  "remitente": "string"
}
```
También se puede consumir desde la misma aplicación en ejecución ingresando a la url http://localhost:8070/swagger-ui/ y seleccionando el método generar-carta
  
 ![image](https://user-images.githubusercontent.com/13786553/169315486-a321e381-ec25-41c4-abab-5b9a43ae6ab6.png)


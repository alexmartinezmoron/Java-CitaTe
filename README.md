Proyecto de ejemplo CitaTe EOI
Introducción
CitaTe es un proyecto en Maven utilizando Java 20 y Spring boot. CitaTe es una web app diseñada para facitlitar el trabajo de las peluquerias. Este proyecto permite a varias empresas darse de alta , asignar trabajadores y servicios especificos a cada trabajo para que los clientes pueden reservar citas y valorar los servicios recibidos.

A la hora de realizar este proyecto he utilizado Jira para organizar los Sprints y GitHub para llevar acabo un correcto control de versiones además de implementar sonar SonarQube en docker para validar los cambios siempre antes de realizar cualquier commit al proyecto.

Modo de empleo: Tines varios entornos de desarollo. Es posible utilizar una BBDD en memoria para pruebas (h2) o en el entorno de desarollo permite desplegar un contedor en docker con Mysql solo es necesairo lanzar el docker compose.

Para el entorno de desarollo en el cual la base de datos es Mysql solo necesitas tener docker desktop instalado, desde la liea de comando tiene que habrar la carpeta main de citate en la cuel se encuentra el docker compose y lanzar el comando docker compose up -d para desplegar.

Este proyecto de ejemplo utiliza Spring Boot 3.0.7, una versión estable y confiable de Spring Boot en el momento de su desarrollo. Además, se emplean tecnologías y herramientas adicionales como Maven para la gestión de dependencias y el empaquetado en formato JAR, y Java 20 como el lenguaje de programación principal.

Para el desarrollo de esta aplicación, se recomienda el uso del entorno de desarrollo IntelliJ IDEA, conocido por su amplio conjunto de características y facilidades para el desarrollo de aplicaciones Java. También se sugiere la instalación de algunos plugins, como Docker para la gestión de contenedores, JPA Buddy para mejorar la experiencia de desarrollo con JPA y Database Navigator para explorar y administrar bases de datos directamente desde el IDE.

Software utilizado
En este proyecto, se utilizan las siguientes tecnologías:

Spring Boot 3.0.7: Spring Boot es un framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones empresariales. La versión 3.0.7 es la utilizada en este proyecto.

Maven: Maven es una herramienta de gestión de dependencias y construcción de proyectos. Se utiliza para gestionar las dependencias del proyecto y para empacar la aplicación en formato JAR.

JAR Packaging: El empaquetado en formato JAR es una forma común de distribuir aplicaciones Java. En este proyecto, se utiliza JAR Packaging para empaquetar la aplicación y hacerla fácilmente ejecutable.

Java 20: Java 20 es la versión de Java utilizada en este proyecto. Java es un lenguaje de programación ampliamente utilizado para el desarrollo de aplicaciones.

Configurar el entorno de desarrollo local
Sigue estos pasos para configurar tu entorno de desarrollo local:

1. Instalar IntelliJ IDEA
Descarga IntelliJ IDEA desde el sitio web oficial.
Sigue las instrucciones de instalación para tu sistema operativo.
Una vez instalado, ábrelo y configura tu entorno de trabajo según tus preferencias.
2. Instalar los plugins indicados
Para aprovechar al máximo el desarrollo en este proyecto, se recomienda instalar los siguientes plugins en IntelliJ IDEA:

Docker: Este plugin te permite gestionar y administrar contenedores Docker directamente desde el IDE, lo que facilita la integración de tus aplicaciones con Docker.
JPA Buddy: El plugin JPA Buddy mejora la experiencia de desarrollo al proporcionar características específicas para trabajar con JPA (Java Persistence API) en tu proyecto.
Database Navigator: Este plugin te permite explorar y administrar bases de datos directamente desde el IDE, lo que facilita la interacción con tu base de datos durante el desarrollo.
SonarLint: SonarLint te ayudará a detectar errores y defectos de programación en el código, consiguiendo siempre que calidad y seguridad lleguen a los estándares más altos.
3. Instalar Docker Desktop
Descarga Docker Desktop según tu sistema operativo.
Sigue las instrucciones de instalación para tu sistema operativo.
Una vez instalado, asegúrate de que Docker esté en funcionamiento y configurado correctamente en tu entorno.
Asegúrate de seguir estos pasos para configurar tu entorno de desarrollo local antes de comenzar a trabajar en el proyecto. Esto te permitirá aprovechar al máximo las herramientas y los recursos necesarios para el desarrollo exitoso del proyecto.

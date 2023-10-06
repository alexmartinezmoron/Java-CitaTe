CitaTe es un proyecto en Maven utilizando Java 20 y Spring boot. 
CitaTe es una web app diseñada para facitlitar el trabajo de las peluquerias.
Este proyecto permite a varias empresas darse de alta , asignar trabajadores y servicios especificos a cada trabajo para que los clientes pueden reservar citas y valorar los servicios recibidos.

A la hora de realizar este proyecto he utilizado Jira para organizar los Sprints y GitHub para llevar acabo un correcto control de versiones además de implementar sonar SonarQube en docker para validar los cambios siempre antes de realizar cualquier commit al proyecto.

Modo de empleo:
Tines varios entornos de desarollo. Es posible utilizar una BBDD en memoria para pruebas (h2) o en el entorno de desarollo permite desplegar un contedor en docker con Mysql solo es necesairo lanzar
el docker compose.

Para el entorno de desarollo en el cual la base de datos es Mysql solo necesitas tener docker desktop instalado, desde la liea de comando tiene que habrar la carpeta main de citate en la cuel se encuentra el docker compose y lanzar el comando docker compose up -d para desplegar.

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

      <form action="servlet">
          <input type="hidden" name="opcion" value="1">
          <label>El mejor char del mundo señores</label>

          </br></br></br>

          <label>Nombre: </label>
          <input type="text" name="nom"> </br></br></br>

          <label>Mensaje: </label>
          <input type="text" name="tet"> </br></br></br>


          <input type="submit" value="Enviar">
      </form>


      </br> </br>
       <a href="mostrarTodoElHistorial.jsp">HISTORIAL</a>



    </body>
</html>
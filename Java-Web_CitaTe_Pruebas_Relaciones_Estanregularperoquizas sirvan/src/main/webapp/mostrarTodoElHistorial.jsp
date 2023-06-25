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





       <div>
                   <ul>
                          <%
                          List<String> historial = (List<String>) request.getSession().getAttribute("historial");
                          %>

                          <!-- Mostrar los datos en el JSP -->
                          <ul>
                          <%
                          for (String dato : historial) {
                              out.println("<li>" + dato + "</li>");
                          }
                          %>
                          </ul>

       </div>




    </body>
</html>
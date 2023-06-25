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
        <% List<String> datos = (ArrayList<>()) session.getAttribute("historial");
        List<datos> lista = datos.getContenido(); %>

        <table border= "1" >
            <tr>
                <th>ID</th>
                <th>Descripcion</th>
                <th>Precio</th>
            </tr>

            <% for(ProductoDTO prod : lista){ %>
                <tr>
                    <td> <%= prod.getId() %> </td>
                    <td> <%= prod.getDescripcion() %> </td>
                    <td> <%= prod.getPrecio() %> </td>
                    <td>
                      <a href="servlet?opcion=6&codigo=<%= prod.getId()%>"> remove</a>
                    </td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
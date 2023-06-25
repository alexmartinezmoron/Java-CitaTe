package es.eoi.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet")
public class ServletCitate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // RECUPERAR LA OPCION
        String op = request.getParameter("opcion");
        switch (op) {
            case "1":

                // Me creo un String nombre y almaceno lo que recojo del form con la varible nom lo mismo con tst

                String nombre = request.getParameter("nom");
                String teztico = request.getParameter("tet");


                /////////




                ////// Crea o recupera la sesion del usuario

                HttpSession miSesion = request.getSession(true);

                ///////////

                List<String> datos = (ArrayList) miSesion.getAttribute("historial");


                // Recuperar el historial almacenado dentro de la sesion
                miSesion.setAttribute("historial",datos);


                // Si es la primera vez que entra, no tiene historial y habra que crearlo

                if (datos == null){
                    datos = new ArrayList<>();
                    miSesion.setAttribute("historial", datos);
                }



                // Añado datos a la lista

                datos.add(nombre);
                datos.add(teztico);



                // Elijo la vista que mostrara el resultado
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

                // Redirijo hacia esa vista
                rd.forward(request, response);

                break;

        }

    }
}

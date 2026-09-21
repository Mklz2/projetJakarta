package be.condorcet.demo2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Exercice2Servlet", value = "/Exercice2Servlet")
public class Exercice2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nom");
        String ageText = request.getParameter("age");
        try{
            int age =  Integer.parseInt(ageText);
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Ma premier servlet</title></head>");
            out.println("<body>");
            if(age>18){
                out.println("<h1>Bienvenue " + name +"</h1>");
                out.println("<p>vous pouvez passer votre permis</p>");
            }
            else{
                out.println("<p>j'espère que tu as skateboard!!!</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }catch (NumberFormatException e){
            PrintWriter out = response.getWriter();
            out.println("<h1> erreur de format");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

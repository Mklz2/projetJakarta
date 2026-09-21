package be.condorcet.demo2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "Exercice1Servlet",
        value = "/Exercice1Servlet",
        initParams = {
                @WebInitParam(name="maintenaceMode", value = "true")
        }
)
public class Exercice1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tes = getInitParameter("maintenaceMode");
        boolean resultest = Boolean.parseBoolean(tes);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Ma premier servlet</title></head>");
        out.println("<body>");
        if(!resultest){
            String name = request.getParameter("nom");
            String ageText = request.getParameter("age");
            try{
                int age =  Integer.parseInt(ageText);
                if(age>18){
                    out.println("<h1>Bienvenue " + name +"</h1>");
                    out.println("<p>vous pouvez passer votre permis</p>");
                }
                else{
                    out.println("<p>j'espère que tu as skateboard!!!</p>");
                }
            }catch (NumberFormatException e){
                out.println("<h1> erreur de format");
            }
        }
        else{
            out.println("<p> Désolé nous somme en maintenance!!!</p>");
        }
        out.println("</body>");
        out.println("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

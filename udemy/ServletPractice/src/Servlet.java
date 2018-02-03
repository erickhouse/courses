import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//path to servlet
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        response.setContentType("text/html");

        //always returns a string, or null if not found. comes from the web.xml
        String cartSize = context.getInitParameter("shopping-cart-size");
        String teamName = context.getInitParameter("team-name");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("<h2>" + request.getParameter("firstName") + "<h2/>");
        out.println("<h2>" + request.getParameter("lastName") + "<h2/>");

        out.println("<h2>" + cartSize + "<h2/>");
        out.println("<h2>" + teamName + "<h2/>");

        out.println("</html></body>");

    }
}

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MVCServlet")
public class MVCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] students = {"Erick", "Alyssa", "Billy", "Bob"};
        request.setAttribute("studentList", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view_students.jsp");

        dispatcher.forward(request, response);
    }
}

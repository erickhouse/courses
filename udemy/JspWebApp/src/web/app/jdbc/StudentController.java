package web.app.jdbc;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

import java.util.List;

/**
 * Created by C on 11/26/16.
 */
@WebServlet(name = "StudentController")
public class StudentController extends HttpServlet {

    private StudentModel _model;

    @Override
    public void init() throws ServletException {
        super.init();

        try{
            _model = new StudentModel(dataSource);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listStudents(request, response);
        }catch (Exception e) {

        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

            List<Student> students = _model.getStudents();

            request.setAttribute("STUDENT_LIST", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/list-student.jsp");

            dispatcher.forward(request,response);
    }
}

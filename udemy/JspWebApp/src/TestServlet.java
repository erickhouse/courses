
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.sql.DataSource;


@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {

    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            myConn = dataSource.getConnection();

            String sql = "select * from student";
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while(myRs.next()){
                String email = myRs.getString("email");
                out.println(email);
            }
        }
        catch (Exception e){
            out.println(e);
        }
    }
}

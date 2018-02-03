package web.app.jdbc;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentModel {

    private DataSource dataSource;

    public StudentModel(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private void close(Connection conn, Statement stmt, ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
            if(conn != null){
                conn.close();
            }
            if(stmt != null){
                stmt.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() throws Exception{

        List<Student> students = new ArrayList<>();
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try{
            myConn = dataSource.getConnection();

            String sql = "select * from student";
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while(myRs.next()) {
                students.add(new Student(
                    myRs.getInt("id"),
                    myRs.getString("first_name"),
                    myRs.getString("last_name"),
                    myRs.getString("email")
                ));
            }

        }
        finally {
            close(myConn, myStmt, myRs);
        }

        return students;
    }

}

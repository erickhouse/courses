<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<%@ page import="web.app.jdbc.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AppMainWindow</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<%
    List<Student> students = (List<Student>)request.getAttribute("STUDENT_LIST");
%>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>UniverityOfWashington</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>email</th>
                </tr>

                <% for(Student temp : students) { %>
                    <tr>
                        <th><%= temp.getFirstName() %></th>
                        <th><%= temp.getLastName() %></th>
                        <th><%= temp.getEmail() %></th>
                    </tr>
                <% } %>
            </table>
        </div>
    </div>
</body>
</html>

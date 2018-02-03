<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*,servlet.Student" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Student> data = new ArrayList<>();
    data.add(new Student("Billy", "Bob", false));
    data.add(new Student("Sally", "Sam", false));
    data.add(new Student("E", "Ehouse", true));

    pageContext.setAttribute("myStudents", data);

%>
<html>
<head>
    <title>foreach student test</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>First</th>
            <th>Last</th>
            <th>Gold</th>
        </tr>

        You can use when/otherwise for if else statements
        When/Otherwise can also be used as a switch
        <c:forEach var="tempStudent" items="${myStudents}">
            <tr>/
                <c:if test="${tempStudent.goldMember}">
                    <td>${tempStudent.firstName}</td>
                    <td>${tempStudent.lastName}</td>
                </c:if>
            </tr>
        </c:forEach>

    </table>

</body>
</html>

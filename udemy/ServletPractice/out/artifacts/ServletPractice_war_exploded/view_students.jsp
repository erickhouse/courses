<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 11/14/16
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>

    <c:forEach var="tempStudent" items="${studentList}">
        ${tempStudent} <br>
    </c:forEach>
</body>
</html>

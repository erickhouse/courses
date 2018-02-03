<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 11/4/16
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    The student is confirmed : ${param.firstName} ${param.lastName}
    Programming Lang : ${param.favLang}
    Current State : ${param.state}

    <ul>
        <%
            String[] langs = request.getParameterValues("favLang1");

            for (String s: langs) {
                out.println("<li>" + s + "</li>");
            }
        %>
    </ul>
</body>
</html>

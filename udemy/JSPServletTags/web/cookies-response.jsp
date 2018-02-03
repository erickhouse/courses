<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 11/5/16
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie Response</title>
</head>
<body>
    <%
        String favLang = request.getParameter("FavLanguage");

        Cookie theCookie = new Cookie("FavLangCookie", favLang);
        theCookie.setMaxAge(60*60*24*365);
        response.addCookie(theCookie);
    %>

    Set your cookie to : ${param.FavLanguage}

    <a href="cookies-homepage.jsp"> Go back to home </a>
</body>
</html>

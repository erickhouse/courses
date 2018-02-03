<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 11/5/16
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cooke Home Page </title>
</head>
<body>
    <%
        String defaultFavorite = "No Lang";

        Cookie[] theCookies = request.getCookies();

        for(Cookie cookie : theCookies){
            if("FavLangCookie".equals(cookie.getName())) {
                defaultFavorite = cookie.getValue();
                break;
            }
        }
    %>

    Your Favorite Language is : <%=defaultFavorite%>
</body>
</html>

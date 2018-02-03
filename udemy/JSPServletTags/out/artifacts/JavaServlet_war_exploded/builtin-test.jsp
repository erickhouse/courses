<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 10/31/16
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>titile</title>
</head>
<body>
User's browser : <%=request.getHeader("User-Agent")%>
User's lang : <%=request.getLocale()%>
</body>
</html>

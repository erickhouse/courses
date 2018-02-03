<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 10/30/16
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h3>HelloWorld</h3>
    My Date is : dumb
    <%= new java.util.Date() %>

    <br>

    <jsp:include page="myhtml.html"/>

  $END$
  </body>
</html>

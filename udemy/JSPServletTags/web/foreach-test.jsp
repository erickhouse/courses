<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String[] cities = {"Kirkland", "Bothell", "Seattle"};
    pageContext.setAttribute("myCities", cities);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="tempCity" items="${myCities}">
    ${tempCity} <br/>
</c:forEach>
</body>
</html>

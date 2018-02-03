<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>function test</title>
</head>
<body>
    <c:set var="data" value="ILikeToCode"/>
    Len of the string  <b>${data}</b>: ${fun:length(data)}

</body>
</html>

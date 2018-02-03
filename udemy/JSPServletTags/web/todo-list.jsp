
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TODO LIST</title>
</head>
<body>

    <form action="todo-list.jsp">
        Add new item <input type="text" name="theItem" />

        <input type="submit" value="Submit" />
    </form>

    <br>

    <%
        List<String> items = (List<String>) session.getAttribute("myToDoList");

        if(items == null){
            items = new ArrayList<>();
            session.setAttribute("myToDoList", items);
        }

        String theItem = request.getParameter("theItem");
        if(theItem != null && !theItem.trim().equals("")){
            items.add(theItem);
        }
    %>

    <hr>
    <ol>
        <%
            for(String temp : items){
                out.println("<li>" + temp + "<li>");
            }
        %>
    </ol>
</body>
</html>

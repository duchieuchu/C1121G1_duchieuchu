<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/13/2022
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%   Map<String,String> dictionary= new HashMap<>();
    dictionary.put("hello","xin chào");
    dictionary.put("what","cái g");
    dictionary.put("1","one");
    dictionary.put("2","two");

    String search = request.getParameter("english");

    PrintWriter writer = response.getWriter();
    writer.println("<html>");
    String result = dictionary.get(search);
    if (result!=null){
        writer.println("english: "+search+"<br>");
        writer.println("vietnamese: "+result);
    }else {
        writer.println("not found");
    }
    writer.println("</html>");
%>
</body>
</html>

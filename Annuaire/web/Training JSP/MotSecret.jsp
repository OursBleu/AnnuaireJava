<%-- 
    Document   : MotSecret1
    Created on : 6 mai 2016, 09:14:55
    Author     : Ours
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Le mot secret est <%= (String)request.getAttribute("MotSecret") %></p>
    </body>
</html>

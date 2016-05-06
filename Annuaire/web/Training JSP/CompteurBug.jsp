<%-- 
    Document   : Compteur
    Created on : 6 mai 2016, 09:12:16
    Author     : Ours
--%>

<%! int compteur = 0; %>
<% compteur ++; %>
<% Integer.parseInt("ble"); %>

<%@ page  %>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>The value of the counter is <%= compteur %></p>
    </body>
</html>

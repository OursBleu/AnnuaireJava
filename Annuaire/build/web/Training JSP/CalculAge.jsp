<%-- 
    Document   : CalculAge
    Created on : 6 mai 2016, 09:30:28
    Author     : Ours
--%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%
    String[] tuple = request.getParameter("birthDay").split("/");
    int year = Integer.parseInt(tuple[2]);
    int month = Integer.parseInt(tuple[1]);
    int day = Integer.parseInt(tuple[0]);
    
    
    Calendar birth = Calendar.getInstance();
    birth.set(Calendar.YEAR, year);
    birth.set(Calendar.MONTH, month);
    birth.set(Calendar.DAY_OF_MONTH, day);
    
    Calendar curr = Calendar.getInstance();
    int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
    curr.add(Calendar.YEAR,-yeardiff);
    if(birth.after(curr))
    {
        yeardiff = yeardiff - 1;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Vous ête né le <%= day %>/<%= month %>/<%= year %>.</p>
        <p>Vous avez <%= yeardiff %> ans.</p>
    </body>
</html>

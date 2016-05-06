<%-- 
    Document   : Age
    Created on : 6 mai 2016, 09:25:28
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
        <form action="CalculAge.jsp" method="POST">
            Date d'anniversaire :
            <input type="date" name="birthDay">
            <input type="submit" value="Enregistrer" />
        </form>
    </body>
</html>

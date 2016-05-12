
<%@page import="fr.oursbleu.annuaire.Contact"%>
<%-- 
    Document   : AddContact
    Created on : 2 mai 2016, 09:31:49
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
        <h1>Ajouter contact</h1>
        
        <form action="${pageContext.request.contextPath}/contact/add" method="POST">
            
            <jsp:include page="<%= Contact.getAddFragment() %>"></jsp:include>
            
        </form>
    </body>
</html>

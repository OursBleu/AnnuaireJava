
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
            
            <p>
                <label for="prenom">Prénom :</label>
                <input id="prenom" type="text" name="prenom" />
            </p>
            
            <p>
                <label for="nom">Nom :</label>
                <input id="nom" type="text" name="nom" /><br />
            </p>
            
            <input type="submit" value="Ajouter" />
            
        </form>
    </body>
</html>

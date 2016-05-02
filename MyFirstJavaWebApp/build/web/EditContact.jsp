<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : EditContact
    Created on : 2 mai 2016, 10:59:49
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
        <h1>Editer contact</h1>
        
        <form action="${pageContext.request.contextPath}/contact/edit" method="POST">
            
            <input type="hidden" value="${contact.id}" name="id" />
            
            <p>
                <label for="prenom">Prénom :</label>
                <input id="prenom" type="text" name="prenom" value="${contact.prenom}" />
            </p>
            
            <p>
                <label for="nom">Nom :</label>
                <input id="nom" type="text" name="nom" value="${contact.nom}" /><br />
            </p>
            
            <input type="submit" value="Enregistrer" />
            
        </form>
            
        
            <a href="${pageContext.request.contextPath}/contact/delete?id=${contact.id}">
                <button>Supprimer </button>
            </a>
       
        
    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : XmlDom
    Created on : 1 mai 2016, 23:11:42
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
        <h1>Liste des contacts</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Prenom</th>
                    <th>Nom</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${contacts}">
                    
                    <tr>
                        <td>${contact.id}</td>
                        
                        <td>
                            <a href="${pageContext.request.contextPath}/contact/edit?id=${contact.id}">
                                ${contact.prenom}
                            </a>
                        </td>
                        
                        <td>${contact.nom}</td>
                    </tr>
                    
                </c:forEach>
            </tbody>
        </table>
        
        <a href="AddContact.jsp">Ajouter un contact</a>
    </body>
</html>

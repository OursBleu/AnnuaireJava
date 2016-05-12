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
            
            <c:set var="contact" value="${contact}" scope="request"></c:set>
            <jsp:include page="${contact.editFragment}"></jsp:include>
            
        </form>
            
        
            <a href="${pageContext.request.contextPath}/contact/delete?id=${contact.id}">
                <button>Supprimer </button>
            </a>
       
        
    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<td>${requestScope.contact.id}</td>
<td><a href="${pageContext.request.contextPath}/contact/edit?id=${requestScope.contact.id}">${requestScope.contact.prenom}</a></td>
<td>${requestScope.contact.nom}</td>

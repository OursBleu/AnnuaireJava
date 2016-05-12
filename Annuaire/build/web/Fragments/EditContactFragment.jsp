<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<input type="hidden" value="${requestScope.contact.id}" name="id" />
    
<p>
    <label for="prenom">Prénom :</label>
    <input id="prenom" type="text" name="prenom" value="${requestScope.contact.prenom}" />
</p>
                
<p>
    <label for="nom">Nom :</label>
    <input id="nom" type="text" name="nom" value="${requestScope.contact.nom}" /><br />
</p>
                
<input type="submit" value="Enregistrer" />
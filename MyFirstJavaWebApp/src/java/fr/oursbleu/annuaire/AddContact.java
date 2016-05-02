/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oursbleu.annuaire;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ours
 */
@WebServlet(name = "AddContact", urlPatterns = {"/contact/add"})
public class AddContact extends HttpServlet 
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Contact c = new Contact(Annuaire.GetNextId());
        c.setNom(GetParam(request, "nom"));
        c.setPrenom(GetParam(request, "prenom"));
        Annuaire.GetContacts().add(c);
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/contact" );
    }
    
    private String GetParam(HttpServletRequest request, String fieldName)
    {
        String res = request.getParameter(fieldName);
        if (res == null) res = "";
        return res;
    }

}

package fr.oursbleu.annuaire.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fr.oursbleu.annuaire.Annuaire;
import fr.oursbleu.annuaire.Contact;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ours
 */
@WebServlet(urlPatterns = {"/contact/edit"})
public class EditContact extends MyServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter(Annuaire.ID));
        Contact c = Annuaire.GetContacts().get(Annuaire.FindById(id));
        
        request.setAttribute(Annuaire.CONTACT, c);
        request.getRequestDispatcher( "/EditContact.jsp" ).forward( request, response );
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter(Annuaire.ID));
        Contact c = Annuaire.GetContacts().get(Annuaire.FindById(id));
        
        c.setNom(GetParam(request, Annuaire.NOM));
        c.setPrenom(GetParam(request, Annuaire.PRENOM));
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/contact" );
    }

}

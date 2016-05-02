package fr.oursbleu.annuaire;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/contact/edit"})
public class EditContact extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter(Annuaire.ID));
        Contact c = Annuaire.GetContacts().get(Annuaire.FindById(id));
        
        request.setAttribute("contact", c);
        request.getRequestDispatcher( "/EditContact.jsp" ).forward( request, response );
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter(Annuaire.ID));
        Contact c = Annuaire.GetContacts().get(Annuaire.FindById(id));
        
        c.setNom(GetParam(request, "nom"));
        c.setPrenom(GetParam(request, "prenom"));
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/contact" );
    }
    
    private String GetParam(HttpServletRequest request, String fieldName)
    {
        String res = request.getParameter(fieldName);
        if (res == null) res = "";
        return res;
    }

}

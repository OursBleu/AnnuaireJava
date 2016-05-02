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
@WebServlet(name = "DeleteContact", urlPatterns = {"/contact/delete"})
public class DeleteContact extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        int id;
        
        try 
        {
            id = Integer.parseInt(request.getParameter(Annuaire.ID));
        }
        catch (NumberFormatException e)
        {
            id = -1;
        }
        
        if (id != -1)
        {
            Annuaire.GetContacts().remove(Annuaire.FindById(id));
        }
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/contact" );
    }

}

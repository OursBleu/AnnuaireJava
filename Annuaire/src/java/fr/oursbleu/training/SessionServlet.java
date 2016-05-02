/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oursbleu.training;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet 
{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        // DEBUG
        
        //ServletContext context = getServletContext( );
        
        // REQUEST
        
        HttpSession session = request.getSession();
        
        Integer compteur = (Integer) session.getAttribute("compteur");
        
        if (compteur == null) 
            compteur = 0;
        
        compteur = compteur + 1;
        
        session.setAttribute( "compteur", compteur);
        
        
        // RESPONSE
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFirstServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>" + compteur + "</p>");
            out.println("</body>");
            out.println("</html>");
        }

    }
}

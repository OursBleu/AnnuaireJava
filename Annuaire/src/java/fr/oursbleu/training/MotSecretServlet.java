/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oursbleu.training;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ours
 */
@WebServlet(name = "MotSecretServlet", urlPatterns = {"/MotSecretServlet"})
public class MotSecretServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        request.setAttribute("MotSecret", "ceciesttrèssecret");
        request.getRequestDispatcher( "/Training JSP/MotSecret.jsp" ).forward( request, response );
    }
}

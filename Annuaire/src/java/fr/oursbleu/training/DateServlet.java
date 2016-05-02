/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oursbleu.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ours
 */
public class DateServlet extends HttpServlet 
{

    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        System.out.print("Init params : " + config.getInitParameter("initInt"));
        System.out.print("Context params : " + config.getServletContext().getInitParameter("globalInt"));
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        
        // RESPONSE
        
        response.setContentType("text/html;charset=UTF-8");
        
        response.addHeader("Refresh", "1");
        
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>" + dateFormat.format(date) + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

package fr.oursbleu.annuaire.servlets;

import fr.oursbleu.annuaire.Annuaire;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class MyServlet extends HttpServlet
{
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        String appPath = config.getServletContext().getRealPath("") + "\\";
        Annuaire.Init(appPath);
    }
 
    @Override
    public void destroy()
    {
        super.destroy();
        Annuaire.Destroy();
    }
    
    protected String GetParam(HttpServletRequest request, String fieldName)
    {
        String res = request.getParameter(fieldName);
        if (res == null) res = "";
        return res;
    }
}
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package fr.oursbleu.annuaire.servlets;

import fr.oursbleu.annuaire.Annuaire;
import fr.oursbleu.annuaire.Contact;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ours
 */
@WebServlet(name = "DisplayContacts", urlPatterns = {"/contact"})
public class DisplayContacts extends MyServlet
{
    private static final String PARAM_SORT = "sort";
    private static final String PARAM_ORDER = "order";
    private static final String ORDER_DESC = "desc";
    private static final String PARAM_FILTER = "filter";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Contact> outputContacts = Annuaire.GetContacts();
        
        String sortParam = (String) request.getParameter(PARAM_SORT);
        String orderParam = (String) request.getParameter(PARAM_ORDER);
        Sort(sortParam, orderParam, outputContacts);
        
        String filterParam = (String) request.getParameter(PARAM_FILTER);
        outputContacts = Filter(filterParam, outputContacts);
        
        request.setAttribute("contacts", outputContacts);
        request.getRequestDispatcher( "/DisplayContacts.jsp" ).forward( request, response );
    }
    
    // FILTER METHODS
    
    List<Contact> Filter(String filterParam, List<Contact> contactList)
    {
        if (filterParam == null) return contactList;
        
        List<Contact> res = new ArrayList<>();
        String lowerCasefilterParam = filterParam.toLowerCase();
        
        Function<Contact, Boolean> filter;
        
        filter = c -> (c.getNom().toLowerCase().contains(lowerCasefilterParam) || c.getPrenom().toLowerCase().contains(lowerCasefilterParam));
        
        for (Contact c : contactList)
        {
            if (filter.apply(c))
            {
                res.add(c);
            }
        }
        
        return res;
    }
    
    // SORT METHODS
   
    void Sort(String field, String order, List<Contact> contactList)
    {
        if (field == null) return;
        
        Function<Contact, String> comparator;
        
        if (field.equals(Annuaire.NOM))
            comparator = c -> c.getNom();
        else
            comparator = c -> c.getPrenom();
        
        if (order != null && order.equals(ORDER_DESC))
            Collections.sort(contactList, (Contact c1, Contact c2) -> comparator.apply(c2).compareTo(comparator.apply(c1)));
        else
            Collections.sort(contactList, (Contact c1, Contact c2) -> comparator.apply(c1).compareTo(comparator.apply(c2)));
    }
    
}
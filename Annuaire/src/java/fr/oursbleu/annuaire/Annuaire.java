/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.oursbleu.annuaire;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author Ours
 */
public final class Annuaire 
{
    public static final String CONTACTS = "contacts";
    public static final String CONTACT = "contact";
    public static final String NEXT_ID = "nextId";
    public static final String ID = "id";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String ADRESSE = "adresse";
    private static int nextId;
    
    private static final String OUTPUT_FILE = "Data/contacts.xml";
    
    private static Boolean isInitialized = false;
    private static Boolean isDestroyed = false;
     
    private static String path;
    private static final List<Contact> contacts = new CopyOnWriteArrayList<>();
    
    public static synchronized void Init(String vpath)
    {
        if (!isInitialized)
        {
            path = vpath;
            LoadContacts();
            isInitialized = true;
        }
    }
    
    public static synchronized void Destroy()
    {
        if (!isDestroyed)
        {
            SaveContacts();
            isDestroyed = true;
        }
    }
    
    public static List<Contact> GetContacts() {
        return contacts;
    }
    
    public static int GetNextId()
    {
        nextId = nextId + 1;
        return (nextId - 1);
    }
    
    public static int FindById(int id)
    {
        int i = 0;
        
        for (Contact c : GetContacts())
        {
            System.out.println(c.getId());
            if (c.getId() == id)
                return i;
            i++;
        }
        
        return -1;
    }
    
    // PERSISTENCE METHODS
    
    private static void LoadContacts()
    {
        GetContacts().clear();
        
        Document doc = GetDocument(path + OUTPUT_FILE);
        doc.getDocumentElement().normalize();
        
        Element root = doc.getDocumentElement();
        nextId = Integer.parseInt(root.getAttribute(NEXT_ID));
        
        NodeList nodeList = root.getChildNodes();
        
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element contactXML = (Element) node;
                Contact contact = new Contact(Integer.parseInt(contactXML.getAttribute("id")));
                
                contact.setPrenom(GetField(contactXML, PRENOM));
                contact.setNom(GetField(contactXML, NOM));
                contact.setAdresse(GetField(contactXML, ADRESSE));
                
                GetContacts().add(contact);
            }
        }
    }
    
    private static void SaveContacts()
    {
        Document doc = GetDocument(path + OUTPUT_FILE);
        doc.getDocumentElement().normalize();
        
        Element root = doc.getDocumentElement();
        root.setAttribute(NEXT_ID, "" + nextId);
        
        while (root.hasChildNodes())
        {
            root.removeChild(root.getFirstChild());
        }
        
        for (Contact contact : GetContacts())
        {
            Element contactXML = doc.createElement(CONTACT);
            
            contactXML.setAttribute(ID, "" + contact.getId());
            AddField(doc, contactXML, PRENOM, contact.getPrenom());
            AddField(doc, contactXML, NOM, contact.getNom());
            AddField(doc, contactXML, ADRESSE, contact.getAdresse());
            
            root.appendChild(contactXML);
        }
        
        SaveDocument(doc, path + OUTPUT_FILE);
    }
    
    // LOW LEVEL XML CONVENIENCE METHODS
    
    private static Document GetDocument(String path)
    {
        try 
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(path);
        } 
        catch (SAXException | IOException | ParserConfigurationException ex) 
        {
            Logger.getLogger(DisplayContacts.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static Element AddField(Document doc, Element item, String fieldName, String fieldValue)
    {
        Element e = doc.createElement(fieldName);
        e.appendChild(doc.createTextNode(fieldValue));
        item.appendChild(e);
        return e;
    }
    
    private static String GetField(Element item, String fieldName)
    {
        return item.getElementsByTagName(fieldName).item(0).getTextContent();
    }
    
    private static void SaveDocument(Document doc, String path)
    {
        try
        {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            DOMSource source = new DOMSource(doc);
            
            StreamResult result = new StreamResult(new File(path));
            //StreamResult result = new StreamResult(System.out);
            
            transformer.transform(source, result);
        }
        catch (TransformerConfigurationException ex)
        {
            Logger.getLogger(DisplayContacts.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex)
        {
            Logger.getLogger(DisplayContacts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

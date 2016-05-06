<%-- 
    Document   : Error
    Created on : 6 mai 2016, 09:44:06
    Author     : Ours
--%>
<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>
Message :
<%=exception.getMessage()%>

StackTrace:
<%
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    exception.printStackTrace(printWriter);
    out.println(stringWriter);
    printWriter.close();
    stringWriter.close();
%>
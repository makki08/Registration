<%-- 
    Document   : success
    Created on : Mar 2, 2014, 9:42:02 PM
    Author     : makki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="org.feu.eac.dto.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <h1>Login Successful!</h1>
        
      <%
        User user = (User)session.getAttribute("user");
      %>
        
        Hello <%=user.getFirst_name() %> <%=user.getLast_name()%>!!!!
    </body>
</html>

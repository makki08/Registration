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
        <style type="text/css">
            body, table, td {
                text-align: center;
                margin-left: auto;
                margin-right: auto;
            }
            .invalid {
            border: 2px solid #ff0000;
            }
        </style>
    </head>
    <body>
        <h1>Login Successful!</h1>
        
      <%
        User user = (User)session.getAttribute("user");
      %>
        
    <h3>Hello <%=user.getFirst_name() %> <%=user.getLast_name()%>!!!! </h3>
    This is your profile:
    <table>
        <tr>
            <td>E-mail :</td> <td><%=user.getEmail() %></td>
            </br>
            <td>Phone :</td> <td><%=user.getPhone() %></td>
            </br>
            <td>Username :</td> <td><%=user.getUsername() %></td>
            </br>
        </tr>
    </table>
            <form action="Controller" method="post">
            <input type="submit" name="logout" value="Logout">
        </form>
    </body>
</html>

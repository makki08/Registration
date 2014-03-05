<%-- 
    Document   : index
    Created on : Mar 2, 2014, 6:57:54 PM
    Author     : makki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
        <h1>Welcome!</h1>
        <form action="Controller" method="post">
            <table>
                <tr><td>Username: </td><td><input type="text" name="username" /></td>
                </tr>
                <tr><td>Password: </td><td><input type="password" name="password" /></td>
                </tr>
                <tr><td><input type="submit" name="login" value="Login"/></td>
                    <td><input type="submit" name="login" value="Register"/></td>
                </tr>
            </table>
        </form>
        <%
            if (!(session.getAttribute("errorMessage") == null 
                    || session.getAttribute("errorMessage").equals(""))) {
            
            %>
        ${errorMessage}
        <% 
                session.removeAttribute("errorMessage");
            }
            %>
    </body>
</html>

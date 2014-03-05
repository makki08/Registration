<%-- 
    Document   : register
    Created on : Mar 5, 2014, 7:27:03 PM
    Author     : makki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
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
        <h1>Register</h1>
        Please fill up all the fields below:
        
        <form action="Controller" method="post">
            <table>
                <tr></br>
                    <td>First Name: </td><td><input type="text" name="first_name" value="" required pattern="[A-Za-z]+(\s[A-Za-z]+)*" title="Example: John, John Paul"></td>
                </tr>
                <tr>
                    <td>Last Name: </td><td><input type="text" name="last_name" value="" required pattern="[A-Za-z]+(\s[A-Za-z]+)*" title="Example: Smith, De Niro"></td>
                </tr>
                <tr>
                    <td>E-mail: </td><td><input type="text" name="email" value="" required pattern="([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)" title="Example: my.email@test.com"></td>
                </tr>
                <tr>
                    <td>Phone Number: </td><td><input type="text" name="phone" value="" required pattern="(\+63|0)[0-9]{3}-?[0-9]{7}" title="Example: +63917-9417384, 0906-6992496"></td>
                </tr>
                <tr>
                    <td>Username: </td><td><input type="text" name="username" value="" required pattern="[A-Za-z]+[A-Za-z0-9]*" title="Email should begin with a letter"></td>
                </tr>
                <tr>
                    <td>Password: </td><td><input type="password" name="password" id="password" required pattern=".{6,}" title="Password should be at least 6 characters long"></td>
                </tr>
                <tr>
                    <td>Confirm Password: </td><td><input type="password" name="password2" id="password2" oninput="check(this)" value="" required pattern=".{6,}" title="Password should be at least 6 characters long"></td>

                    <script language='javascript' type='text/javascript'>
                    function check(input) {
                        if (input.value !== document.getElementById('password').value) {
                            input.setCustomValidity('The two passwords must match.');
                        } else {
                            // input is valid -- reset the error message
                            input.setCustomValidity('');
                        }
                        
                    }
                    </script>
                    <div>
                        <%
                            if (!(session.getAttribute("errorMessage2") == null
                                    || session.getAttribute("errorMessage2").equals(""))) {

                        %>
                        ${errorMessage2}
                        <%  session.removeAttribute("errorMessage2");
                            }
                        %>
                    </div>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="register" value="Submit"/></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>

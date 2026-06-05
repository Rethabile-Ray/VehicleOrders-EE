<%-- 
    Document   : login
    Created on : 05 Jun 2026, 11:05:42
    Author     : mokau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Login</h1>
        <form action="j_security_check" method="POST">
        <table>
            <tr>
                <td>UserName</td>
                <td><input type="text" name="j_username" required=""></td>
            </tr>
             <tr>
                <td>Password</td>
                <td><input type="password" name="j_password" required=""></td>
            </tr>
             <tr>
                <td>Login</td>
                <td><input type="submit" value="LOGIN" ></td>
            </tr>
        </table>
            </form>
    </body>
</html>

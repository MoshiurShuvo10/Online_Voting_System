
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voter login Page</title>
    </head>
   <body background="pic.jpg">
        <%
             String votercardnumber =(String) request.getAttribute("VCN");
            
        %>
        
        <center>
            <form action="Voter_Login" method="post">
                <table>
                     <tr>
                        <td>Voter Card Number</td>
                        <td><input type="text" name="voter_card_number" value="<%=votercardnumber%>" readonly/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Login Voter</td>
                    </tr>
                      <tr>
                        <td>Voter Email</td>
                        <td><input type="text" name="voter_email" required/></td>
                    </tr>
                      <tr>
                        <td>Voter password</td>
                        <td><input type="password" name="voter_password" required/></td>
                    </tr>
                      <tr>
                        <td></td>
                        <td><input type="submit" value="Login"/></td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>

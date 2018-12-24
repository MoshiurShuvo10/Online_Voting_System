

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link href="css/home.css" rel="stylesheet" type="text/css"> 
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.jsp" %>
        <title>JSP Page</title>
    </head>
   <body background="pic.jpg">
   <center>
            <form action="Register" method="post">
                <fieldset>
                   <table>
                <tr>
                    <td></td>
                    <td><h1 >User Registration Form</h1></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td> <input name="name" type="text" required /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td> <input name="surname" type="text" required /></td>
                </tr>
               
                <tr>
                    <td>Address</td>
                    <td><input name="address" type="text" required /></td>
                </tr>
                
                <tr>
                    <td>Date of Birth</td>
                    <td><input name="dob" type="text" required /></td>
                </tr>
                <tr>
                    <td>Contact no.</td>
                    <td><input name="contact" type="text" required /></td>
                </tr>
                 <tr>
                    <td>Email</td>
                    <td><input name="email" type="text" required /> </td>
                </tr>
                 <tr>
                    <td>password</td>
                    <td><input name="password" type="password" required /> </td>
                </tr>
                <tr>
                    <td>NID</td>
                    <td><input name="nid"   type="text" required /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input value="Register"   type="submit" class="btn" /></td>
                </tr>
                 
                
            </table>
                </fieldset> 
            </form>
   </center>
</body>

</html>

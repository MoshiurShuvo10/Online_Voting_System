<%-- 
    Document   : index
    Created on : Sep 28, 2016, 4:20:14 PM
    Author     : Oops
--%>



<html>
<head>
<title>Online Voating System</title>
<%@ include file="header.jsp"%>
<link href="css/home.css" rel="stylesheet" type="text/css">
<body background="pic.jpg">   
    
<%--   <div class="back_image">
        
<div class="reg" style="padding-top: 35px;"> --%>
       <center>
            <form action="AdminLogin" method="post">
                
                <table>
                    <tr>
                        <td></td>
                        <td><h1>Admin Login</h1></td>                       
                    </tr>
                    <tr>
                        <td></td>
                        <td><input name="admin_name"  placeholder="admin Name" type="text"></td> 
                    </tr>
                    <tr>
                        <td></td>
                        <td> <input name="admin_pass"  placeholder="admin Password" type="password"></td>                       
                    </tr>
                    <tr>
                        <td></td>
                        <td> <input value="Login"  type="submit" class="btn"> </td> 
                    </tr>
                 
                </table>
                 
            </form>

       </center>

</body>


</html> 
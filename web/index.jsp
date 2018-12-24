
<html>
<head>
<title>Online Voating System</title>
<%@ include file="header.jsp"%>
<!-- <link href="home.css" rel="stylesheet" type="text/css"> -->
<body background="pic.jpg">
<center>
    
            <form action="Password" method="post">
                 
            <table>
                <tr>
                    <td></td>
                    <td><h3>User Login</h3></td>
                </tr>
                 <tr>
                    <td>Enter Voter Card Number</td>
                    <td><input name="voter_card_number"  type="text" required/></td>
                </tr>
                 <tr>
                    <td>Enter Email</td>
                    <td><input name="voter_email"  type="text" required/></td>
                </tr>
                 <tr>
                    <td>Enter Password</td>
                    <td><input name="voter_password"  type="password" required/></td>
                </tr>
                 <tr>
                    <td></td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
           </form>
            <table>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="reg.jsp">Register Here for a Voter Card Number</td>
                </tr>
                 <tr>
                    <td></td>
                    <td><a href="adminlogin.jsp">Admin</td>
                </tr>
            </table>
      
</center>
</body>


</html> 


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>header</title>
    </head>
    <body background="pic.jpg">
        <%
            String n = (String) session.getAttribute("adminname");
            if (n == null) {%>
        <div class="back">
            <div class="logo">
                <center><label style=" font-size: 30px;color:white; margin-left:95px; ">Welcome To Online Voating System</label></center>
            </div>
            <div class="menu1">
                <ul>
                    <li><a href="index.jsp">Home</a> </li>
                    <li><a href="aboutus.jsp">About</a></li> 
                    <li><a href="contactus.jsp">Contact us</a></li> 
                </ul>
             
            </div>
        </div>


        <%} else {%>
        
       
         <div class="back">
            <div class="logo">
                <label style=" font-size: 35px;color: white; margin-left:50px; ">Welcome To Online Voating System</label>
            </div>
            <div class="menu1">
                <ul>
                    <li><a href="index.jsp">Home</a> </li>
                    <li><a href="aboutus.jsp">About</a></li> 
                    <li><a href="contactus.jsp">Contact us</a></li> 
                </ul>
             
            </div>
            
        </div>
        <%}
        %>




    </body>
</html>

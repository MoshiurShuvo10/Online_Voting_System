

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<title>Online Voating System</title>
<%@ include file="header.jsp"%>
<link href="css/home.css" rel="stylesheet" type="text/css">
<body background="pic.jpg">
    <div class="back_image">
        
         <%
            String name = request.getParameter("name");
            
        %>
        
        <div class="reg">
              <pre>
            <form action="index.jsp" method="post">
            
                         <h3 style="margin-top: -15px;margin-left: 100px;">Sorry Vote is allowed only once for a particular voter card number... <br>and You already used this voter card number: </h3>
                         <h2 style="margin-top: -40px;margin-left: 100px;"><%out.println(name);%></h2>
             
                       <input value="OK"   type="submit"  class="btn" style="padding-bottom: 40px; width: 150px;"> 
                     
            </form>
            </pre>
             
        </div>
        
  
    </div>

</body>


</html>

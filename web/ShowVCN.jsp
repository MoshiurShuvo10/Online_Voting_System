<%-- 
    Document   : ShowVCN
    Created on : Nov 14, 2018, 12:23:59 PM
    Author     : rabiul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VCN showing Page</title>
    </head>
   <body background="pic.jpg">
      <center>  <h1>
            <% String voter_card_number =(String) request.getAttribute("voterCardNumber");
         
           
               
            %>
            voter card number: <%=voter_card_number%>
            
          
        <br><br><br>   <a href="index.jsp">Quit</a>
        
          </h1> </center>
    </body>
</html>

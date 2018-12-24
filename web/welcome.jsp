<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/voating";

String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Blob image = null;
Connection con = null;
byte[ ] imgData = null ;
Statement stmt = null;
ResultSet rs = null;
Connection connection=null;
Statement statement;


%>


<!DOCTYPE html>
<html>
    <head>
<title>Online Voating System</title>
<%@ include file="header.jsp"%>
<!--<link href="css/home.css" rel="stylesheet" type="text/css"> -->
   </head>
    <body background="pic.jpg">
    
               <% try{
        connection = DriverManager.getConnection(connectionUrl, userid, password);
        statement=connection.createStatement();
       
       String sql = "select * from candidate" ;
       
       String voterCardnumber =(String)request.getAttribute("VCN") ;
       String voterEmail =(String)request.getAttribute("VE") ;
       String voterPassword =(String)request.getAttribute("VP") ; 
                %> 
                
                <center>
                    <form action="Vote" method="post">
                    <table border="2px solid" width="65%">
                        
                    <tr>
                        <td></td>
                        <td>Voter Card Number</td>
                        <td> <input name="vcNumber"  value="<%=voterCardnumber%>" type="text" readonly/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>User Name</td>
                        <td><input type="text" name="vMail" value="<%=voterEmail%>" readonly/></td>
                    </tr>
                     <tr>
                        <td></td>
                        <td>User Password</td>
                        <td><input type="password" name="vPassword" value="<%=voterPassword%>" readonly/></td>
                    </tr>
                   
                    <tr>
                        <td><h3>candidate Name</h3></td>
                        <td><h3>candidate Party</h3></td>
                        <td></td>
                    </tr>
                
                  
            <%  stmt=connection.createStatement(); 
                rs = stmt.executeQuery("select candidate_name,candidate_party from candidate ");
                
                  while(rs.next()){          
            %> <tr>
                   <td><%=rs.getString("candidate_name")%></td>
                   <td><%=rs.getString("candidate_party")%></td>  
                   <td><input type="radio" name="candidateName" value="<%=rs.getString("candidate_name")%>"/></td>
                    
                 <% } 
                  connection.close(); 
                   }
                   catch (Exception e) {
            e.printStackTrace();
            } 
            %>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td> <input value="Vote" type="submit"  class="btn"  /></td>
            </tr>  
              </table> 
            </form>
           </center>

</body>

</html>

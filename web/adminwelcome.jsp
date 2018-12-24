
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<title>Online Voating System</title>
<%@ include file="header.jsp"%>
<body background="pic.jpg">

    <%
  
   String s1 = (String)session.getAttribute("adminname");

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voating", "root", "");
   
   Statement stmt;
   ResultSet rs;  %>
<center>
    <table border="2px solid" width="50%">
        <tr>
            <td><h4>Candidate Partie</h4></td>
            <td><h4>Candidate Name</h4></td>
            <td><h4>Votes</h4></td>
        </tr>
     <%   stmt = con.createStatement();
        rs = stmt.executeQuery("select partie,count(partie) as c from vote group by partie");
    while(rs.next()){
        Statement stmt2 = con.createStatement();
    ResultSet rs2 = stmt2.executeQuery("select candidate_name,candidate_party from candidate where candidate_name='"+rs.getString("partie")+"'");
    %>

        <tr><%if(rs2.next())%>
            <td><%=rs2.getString("candidate_party")%></td>
            <td><%=rs.getString("partie")%></td>
            <td><%=rs.getString("c")%></td>
            
        </tr>       
   <%}%>
   
      </table>
  </center>
             <div  margin-left: 1500px; ">
                 <form action="adminlogout.jsp">
                     <input type="submit" value="logout" style=" background-color: #FF9933">
                     
                 </form>
             </div>
</body>


</html> 
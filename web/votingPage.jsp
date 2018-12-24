

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>voting Page</title>
        <%@ include file="header.jsp"%>
    </head>
   
    <body background="pic.jpg">
        <h1>Voting page</h1>
    <!--    
        <%
        /*      MyDb mydb = new MyDb() ; 
              Connection con = mydb.getCon() ;
              String sql = "select candidate_name from candidate" ; 
              Statement statement = con.createStatement() ;  
              ResultSet rs = statement.executeQuery(sql) ; 
              
              
         List candidate_list = new ArrayList() ; 
         while(rs.next())
         {    String c = rs.getString("candidate_name") ;
             candidate_list.add(c) ;          
         }
         Iterator it = candidate_list.iterator() ; 
         String can_name ;
         while(it.hasNext())
         {
           //  can_name = (String)it.next() ; */
         %>
         <input type="radio" name="candidateName" value="<%=//can_name%>"/><%=//can_name%><br>
         
         <%}%> -->
         <input type="submit" value="vote" />
            
        
    </body>
</html>

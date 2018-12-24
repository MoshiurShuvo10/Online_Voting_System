
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add candidate Page</title>
        <%@ include file="header.jsp"%>
    </head>
    <body>
        <form action="AddCandidate" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Candidate Name</td>
                    <td><input type="text" name="candidate_name" required></td>

                </tr>
                <tr>
                  <td>Candidate Party</td>
                    <td><input type="text" name="candidate_party" required></td>
                </tr>
                 <tr>
                  <td></td>
                    <td><input type="submit" value="add" required></td>
                </tr>
            </table>
        </form>
         <div  margin-left: 1500px; ">
                 <form action="adminlogout.jsp">
                     <input type="submit" value="logout" style=" background-color: #FF9933">
                     
                 </form>
             </div>
    </body>
</html>

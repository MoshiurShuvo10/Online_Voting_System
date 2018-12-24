

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           String name = request.getParameter("name");
           String surname = request.getParameter("surname");
           String address = request.getParameter("address");
           String dob = request.getParameter("dob");
           String contact = request.getParameter("contact");
           String email = request.getParameter("email");
           String password = request.getParameter("password") ;
           String nid = request.getParameter("nid") ;
          
      
         MyDb db = new MyDb();
         
         
          Connection con = db.getCon();
    
    Statement stCheck = con.createStatement();
    ResultSet Check = stCheck.executeQuery("select NID from voter_register where NID='"+nid+"'");
   
    
    if(Check.next()){
         out.println("<script type=\"text/javascript\">");
         out.println("alert('You can not register twice');");
         out.println("</script>");
         request.getRequestDispatcher("reg.jsp").include(request, response);
    }
    
    
    else{
             
               String insert = "insert into voter_register(name,surname,contact,address,dob,email,password,NID) values( ?,?,?,?,?,?,?,?)" ; 
               PreparedStatement ps = con.prepareStatement(insert) ; 
               ps.setString(1,name) ; 
               ps.setString(2,surname) ;
               ps.setString(3,contact);
               ps.setString(4,address);
               ps.setString(5,dob);
               ps.setString(6,email);
               ps.setString(7,password);
               ps.setString(8,nid);
               int i = ps.executeUpdate();
               if(i!=0)
               {
           Statement st = con.createStatement() ; 
           ResultSet rs2 = st.executeQuery("select * from voter_register where email='"+email+"' and password='"+password+"'") ; 
           
           if(rs2.next()){
               
           String voterCardNumber = rs2.getString("uid") ;
           String voterEmail=rs2.getString("email");
           String voterPassword=rs2.getString("password");
           
           String psVoterCardCheck = "select voter_card_number,voter_email,voter_password from vote where voter_card_number='"+voterCardNumber+"' and voter_email='"+voterEmail+"' and voter_password='"+voterPassword+"'" ; 
           Statement  psCheck= con.createStatement(); 
           ResultSet rsCheck = psCheck.executeQuery(psVoterCardCheck) ; 
           if(rsCheck.next())
           {
         out.println("<script type=\"text/javascript\">");
         out.println("alert('You can not vote twice');");
         out.println("</script>");
         request.getRequestDispatcher("reg.jsp").include(request, response);
           }
           else{
           
           String insertVCN = "insert into temp_voter_card_number(voter_card_number,voter_email,voter_password) values(?,?,?)" ; 
           PreparedStatement psTemp = con.prepareStatement(insertVCN) ; 
           psTemp.setString(1,voterCardNumber) ;
           psTemp.setString(2,email);
           psTemp.setString(3,password);
           psTemp.executeUpdate();

           request.setAttribute("voterCardNumber",voterCardNumber); 

           RequestDispatcher rd=request.getRequestDispatcher("ShowVCN.jsp");
           rd.forward(request,response);  
           } 
           }
    }
         else{
         out.println("<script type=\"text/javascript\">");
         out.println("alert('register failed');");
         out.println("</script>");
         request.getRequestDispatcher("reg.jsp").include(request, response);
               }
     
             }
       
        }
     catch (SQLException ex) {
                Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
            }}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}




import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Vote extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String voter_card_number = request.getParameter("vcNumber");
            String candidate = request.getParameter("candidateName");
            String voteremail=request.getParameter("vMail") ; 
            String voterpassword=request.getParameter("vPassword") ; 
         
          MyDb db = new MyDb();
          Connection con = db.getCon();
            try {
                Statement stmt = con.createStatement();
               
                String voter_query = "insert into vote(voter_card_number,voter_email,voter_password,partie) values (?,?,?,?)" ; 
                
                 PreparedStatement ps = con.prepareStatement(voter_query) ; 
                
                 ps.setString(1,voter_card_number);
                 ps.setString(2,voteremail);
                 ps.setString(3,voterpassword);
                 ps.setString(4,candidate)  ;
               
                 int i=ps.executeUpdate();
                 if(i != 0)
                 {
                     out.println("<script type=\"text/javascript\">");
                     out.println("alert('voted successfully');");
                     out.println("</script>");
                     request.getRequestDispatcher("index.jsp").include(request, response);
                     
                 }
                
            } catch (SQLException ex) {
                Logger.getLogger(Vote.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

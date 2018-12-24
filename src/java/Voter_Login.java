

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Voter_Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
            String voterCardNumber = request.getParameter("voter_card_number") ;
            String voterEmail = request.getParameter("voter_email") ; 
            String voterPassword = request.getParameter("voter_password") ; 
            
            MyDb mydb = new MyDb() ; 
            Connection con = mydb.getCon() ;
            
            String searchVoter = "select email,password from voter_register where uid='"+voterCardNumber+"'" ;
            Statement st = con.createStatement() ;
            ResultSet rs = st.executeQuery(searchVoter); 
            if(rs.next()){
        
        if(voterEmail.equals(rs.getString("email")) && voterPassword.equals(rs.getString("password"))) {
            HttpSession session = request.getSession();
            session.setAttribute("voterEmail",voterEmail) ; 
            session.setAttribute("voterPassword",voterPassword) ;                
            request.getRequestDispatcher("VoterLogin.jsp").include(request, response);
        }  
        else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Bad user name or password');");
                out.println("</script>");
                request.getRequestDispatcher("VoterLogin.jsp").include(request, response);
            }
           }
             
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Voter_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Voter_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

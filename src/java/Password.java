
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

public class Password extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
             {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           String Voter_Card_Number = request.getParameter("voter_card_number");
           String Voter_Email = request.getParameter("voter_email");
           String Voter_Password=request.getParameter("voter_password");
           
           MyDb db = new MyDb();
           Connection con = db.getCon();
           
   Statement stmt = con.createStatement();
   ResultSet rs1= stmt.executeQuery("select uid,email,password from voter_register where uid='"+Voter_Card_Number+"' and email='"+Voter_Email+"' and password='"+Voter_Password+"'");
   Statement stmt2=con.createStatement() ; 
   ResultSet rs2 = stmt2.executeQuery("select voter_card_number,voter_email,voter_password from vote where voter_card_number='"+Voter_Card_Number+"' and voter_email='"+Voter_Email+"' and voter_password='"+Voter_Password+"'");
 
   //if voter is registered..
   if(rs1.next()){ 
       // if voter is registered and voted then block him/her
       if(rs2.next()){
     response.sendRedirect("votercheck.jsp?name="+Voter_Card_Number);
     out.println("You already voted........"+rs2.getString("voter_card_number"));
       }
       //if voter is registered but didn't voted,redirect him/her to voting page after validation using mail and password
       else{
       request.setAttribute("VCN",Voter_Card_Number); 
       request.setAttribute("VE",Voter_Email); 
       request.setAttribute("VP",Voter_Password); 
       
       RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
       rd.forward(request,response);
       }
       
       
   }
   //if voter isn't registered
   else{
 out.println("<script type=\"text/javascript\">");
 out.println("alert('invalid voter card number or email and password did not match');");
 out.println("</script>");
 request.getRequestDispatcher("index.jsp").include(request, response);
           
    } 
       
   }
catch (SQLException ex) {
                Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
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

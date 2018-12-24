
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class AddCandidate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            String can_name = request.getParameter("candidate_name");
            String can_party = request.getParameter("candidate_party") ; 
           
            
                   
          MyDb db = new MyDb();
          Connection con = db.getCon();
          
          String insertCan = "insert into candidate(candidate_name,candidate_party) values(?,?)";
          PreparedStatement ps = con.prepareStatement(insertCan) ;
          ps.setString(1,can_name);
          ps.setString(2,can_party) ;
          
          int i = ps.executeUpdate();
          if(i!=0)
          {
               out.println("<script type=\"text/javascript\">");
               out.println("alert('candidate added successfully');");
               out.println("</script>");
               request.getRequestDispatcher("adminPage.jsp").include(request, response);
          }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddCandidate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddCandidate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

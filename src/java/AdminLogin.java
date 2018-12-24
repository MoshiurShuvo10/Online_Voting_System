

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

public class AdminLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String admin_name = request.getParameter("admin_name");
            String admin_pass = request.getParameter("admin_pass");
            
            
            
          MyDb db = new MyDb();
          Connection con = db.getCon();
            try {
                
                String sql = "select user_name,password from admin_login where user_name=? and password=?" ;
                PreparedStatement ps = con.prepareStatement(sql) ; 
                ps.setString(1,admin_name) ; 
                ps.setString(2,admin_pass) ; 
                
                ResultSet rs = ps.executeQuery() ; 
              
               if(rs.next()){
                   HttpSession  session = request.getSession();
                   session.setAttribute("adminname", admin_name);
                   session.setAttribute("adminpass",admin_pass);
                   response.sendRedirect("adminPage.jsp");
               }else{
                      out.println("Wrong Password or user name");
                   }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

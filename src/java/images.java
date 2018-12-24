import java.sql.Blob;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class images {
    
     public static byte[] getPhoto (Connection conn, int iNumPhoto)
       throws Exception, SQLException
  {

    String req = "" ;
    Blob img ;
    byte[] imgData = null ;
    Statement stmt = conn.createStatement ();
   
    req = "Select candidate_photo From candidate Where ImageID " ;
   
    ResultSet rset  = stmt.executeQuery ( req );
   
    while (rset.next ())
    {   
      img = rset.getBlob(1);
      imgData = img.getBytes(1,(int)img.length());
    }   
   
    rset.close();
    stmt.close();
   
    return imgData ;

  }
    
}

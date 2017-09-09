
package tcs;

import java.sql.Connection;
import java.sql.DriverManager;

public class ExCon {
    
   public static Connection con;
    
    
   
    
    public static void call(){
         try {
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             con=DriverManager.getConnection("jdbc:odbc:tcs","sa","123");
             System.out.println("connected");
         } catch (Exception e) {
         }
     
    }
    
    
}


package supermarket_billing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Items {
  
    public static void getList()
    {
         try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", "");
                    Statement s = con.createStatement();
                    PreparedStatement ps = con.prepareStatement("select * from items");
                        
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            PreparedStatement ps1 = con.prepareStatement("Select * from items ORDER BY I_no");
                          
                            ResultSet rs1 = ps1.executeQuery();
                    
                        while (rs1.next()) {
                            System.out.print(rs1.getString(1)+"   ");
                            System.out.print(rs1.getString(2)+"   ");
                            System.out.print("Rs."+rs1.getString(3)+"   ");
                            System.out.println();
                            
                }
                } else {
                    System.out.println("Some error occured !!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

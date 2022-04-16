
package supermarket_billing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    
    public static void deleteItem()
    {
        System.out.println("Enter item number to be deleted:");
        Scanner s=new Scanner(System.in);
        int ch=s.nextInt();
        try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", "");
                    
                    PreparedStatement ps = con.prepareStatement("delete from items where I_no=?");
                        
                        ps.setInt(1,ch);
                        int i = ps.executeUpdate();
                        if (i==1) {
                            Items.getList();
                } else {
                    System.out.println("Some error occured !!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
}

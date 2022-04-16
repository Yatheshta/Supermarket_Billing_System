
package supermarket_billing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Add {
    
    public static void addItem()
    {
        //System.out.println("Enter item number:");
        Scanner s=new Scanner(System.in);
        //int no=s.nextInt();
        System.out.println("Enter item name:");
        String name=s.nextLine();
        System.out.println("Enter item price:");
        int price=s.nextInt();
        try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", "");
                    
                    PreparedStatement ps = con.prepareStatement("insert into items (I_name,I_price) values(?,?)");
                        //ps.setInt(1,no);
                        ps.setString(1,name);
                        ps.setInt(2,price);
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

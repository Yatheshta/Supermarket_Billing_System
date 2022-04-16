
package supermarket_billing;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Supermarket_Billing {

    
    public static void main(String[] args) {
        
        System.out.println("*******WELCOME TO SUPERMARKET******");
        System.out.println("Enter 1 if you are ADMIN");
        System.out.println("Enter 2 if you are a CASHIER");
        Scanner s= new Scanner(System.in);
        int choice=s.nextInt();
        Connection con;
        int c=1;
        PreparedStatement ps;
        switch(choice)
        {
            case 1:
                System.out.println("ADMIN LOGIN: ENTER USERNAME....");
                String n=s.next();
                
                System.out.println("ENTER PASSWORD....");
                String pass=s.next();
                try {
                con=DriverManager.getConnection("jdbc:mysql://localhost/bill", "root", "");
                ps=con.prepareStatement("SELECT username,password FROM admin WHERE username=? AND password=?;");
                ps.setString(1,n);
                ps.setString(2,pass);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {  
                    
                    Items.getList();
                    System.out.println("Enter: 1.Delete Item 2.Add Item 3.Exit");
                    int ch=s.nextInt();
                    switch(ch)
                    {
                        case 1:
                            Delete.deleteItem();
                            
                            while(c==1)
                            {
                              System.out.print("delete another item?? Enter 1....");
                              c=s.nextInt();
                              Delete.deleteItem();
                            }
                            break;
                        case 2:
                            Add.addItem();
                            c=1;
                            while(c==1)
                            {
                              System.out.print("add another item?? Enter 1....");
                              c=s.nextInt();
                              Add.addItem();
                            }
                            break;
                        case 3:
                            exit(0);
                    }
                    
                }
                else
                {
                     System.out.println("Invalid Username or Password!!");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            break;
            case 2:
                System.out.println(" CASHIER LOGIN: ENTER USERNAME....");
                n=s.next();
                System.out.println("ENTER PASSWORD....");
                pass=s.next();
                try {
                con=DriverManager.getConnection("jdbc:mysql://localhost/bill", "root", "");
                ps=con.prepareStatement("SELECT name,password FROM cashier WHERE name=? AND password=?;");
                ps.setString(1,n);
                ps.setString(2,pass);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {  
                    
                    ArrayList<Purchase>bill=Bills.getBill();
                    int sum=0;int i=0;int j=0;Purchase p;
                    System.out.println("Name            "+"Quantity       "+"Price(in Rs.)       ");
                    System.out.println("==========================================");
                    while(j!=bill.size()){
                        p=bill.get(j);
                        System.out.println(p);
                        j++;
                    }
                    //System.out.println(bill);
                    while(i!=bill.size()){
                        sum += bill.get(i).total;
                        i++;
                    }
                    System.out.println("Total Amount: Rs."+sum);
                    System.out.println("THANK YOU VISIT AGAIN.....");
                    
                }
                else
                {
                     System.out.println("Invalid Username or Password!!");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            break;
            default:
                exit(0);
       }                                    

                
        }
        
    }
    


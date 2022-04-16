
package supermarket_billing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Bills {
    
     Connection con;
     PreparedStatement ps;
     
     
    public static ArrayList getBill()
    {
        System.out.println("GENERATE BILL....");
        int sum=0;
        Items.getList();
        ArrayList<Purchase> list=new ArrayList<Purchase>(); 
        int ch=1;
        do{
            System.out.println("Enter the Item Number : ");
            Scanner s=new Scanner(System.in);
            int ino=s.nextInt();
            System.out.println("Enter the quanity : ");
            int quant=s.nextInt();
            Purchase p=new Purchase(ino,quant);
            list.add(p);
            
            System.out.println("Press 0 exit 1 to continue.... ");
            ch=s.nextInt();
        }while(ch==1); 
        return list;
    }
}

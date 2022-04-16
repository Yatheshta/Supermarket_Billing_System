
package supermarket_billing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Purchase {
    int i_no;
    int quant;
    int price;
    int total;
    String name;
    public Purchase(int i,int q){this.setIno(i);this.setQuant(q);this.getDetails();}
    public  int getIno(){ return i_no;}
    public int getQuant(){return quant;}
    public int getPrice(){ return price;}
    public String getName(){return name;}
    public  int getTotal(){return total;}
    
    public void setIno(int i){i_no=i;}
    public void setQuant(int q){quant=q;}
    public void setPrice(int p){price=p;}
    public void setName(String n){name=n;}
    
    public void calc_total(){ total=(quant*price);}
    
    public  void getDetails(){
        
        try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", "");
                    
                    PreparedStatement ps = con.prepareStatement("select*from items where I_no=?");
                        ps.setInt(1,this.getIno());
                        ResultSet rs= ps.executeQuery();
                        if (rs.next()) {
                            this.setName(rs.getString(2));
                            this.setPrice(rs.getInt(3));
                            this.calc_total();
                } else {
                    System.out.println("Some error occured !!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public String toString(){
     return(name+"    "+quant+"     "+total+"    "+"\n");
    }
}

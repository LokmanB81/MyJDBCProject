package jdbc_practice;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // driver yükle
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                                                    "postgres",
                                                "72653421Lb");
        Statement st=con.createStatement();
        //
        ResultSet veri=st.executeQuery("select * from ogrenciler");
         while (veri.next()){
            /* System.out.println(veri.getInt(1)
                     +" "+veri.getString(2)
                     +" "+veri.getString(3)
                     +" "+veri.getString(4));

             */

             System.out.printf("%-6d %-15.15s %-8s %-8s\n",
                     veri.getInt(1),
                     veri.getString(2),
                     veri.getString(3),
                     veri.getString(4));
         }

            con.close();
         st.close();
         veri.close();




    }
}

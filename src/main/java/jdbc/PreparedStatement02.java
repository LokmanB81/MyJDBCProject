package jdbc;

import java.sql.*;

public class PreparedStatement02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","72653421Lb");
        Statement st=con.createStatement();

      //  String sql1="select * from ?";

        PreparedStatement pst1= con.prepareStatement("select * from ?");
        pst1.setString(1,"companies");
        System.out.println(pst1);



        ResultSet rst1=st.executeQuery("select * from companies");
        while (rst1.next()){

            System.out.println(rst1.getInt(1)+" "+rst1.getString(2)+" "+rst1.getInt(3));

        }

        con.close();
        st.close();

    }
}

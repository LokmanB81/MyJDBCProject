package jdbc_practice;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "72653421Lb");
        PreparedStatement ps=con.prepareStatement("select * from ogrenciler");
        //
        ResultSet rs=ps.executeQuery();

        ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println("Sutun Sayisi : " +rsmd.getColumnCount());
        System.out.println(rsmd.getColumnName(1));
        System.out.println(rsmd.getColumnName(2));
        System.out.println(rsmd.getColumnName(3));
        System.out.println(rsmd.getColumnName(4));
        System.out.println(rsmd.getColumnTypeName(1));
        System.out.println(rsmd.getColumnTypeName(2));
        System.out.println(rsmd.getColumnTypeName(3));
        System.out.println(rsmd.getTableName(1));
    }
}

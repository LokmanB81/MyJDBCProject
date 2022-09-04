package jdbc;

import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","72653421Lb");
        Statement st=con.createStatement();

        ///1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak
        //--return yapan bir fonksiyon oluşturun.

       //1. adım ;fonksiyon kodunu yaz
        String sql1 = "CREATE OR REPLACE FUNCTION toplamaF(x NUMERIC, y NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                " BEGIN\n" +
                " \n" +
                " RETURN x+y;\n" +
                " \n" +
                " END\n" +
                "$$";

        //2. Adım: Fonksiyonu çalıştır.
        st.execute(sql1);
        //3. fonksiyonu cagir
        CallableStatement cst1=con.prepareCall("{? =call addf(?, ?)}");

        //4. adim; return icin registerOutParameter() metodunu
        // parametreler icin set() metodlardan uygun olanı kullan
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,5);
        cst1.setInt(3,6);

        //5. adim ; çalıştirmak icin execute() metodunu kullan.
        cst1.execute();

        //6. adim ; sonucu fonksiyonun return data type'ine gore uygun get()
        // metodlardan çagiriyoruz
        System.out.println(cst1.getBigDecimal(1));

        //2. Örnek: Koninin hacmini hesaplayan bir function yazın
        String sql2 = "CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC, h NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                " BEGIN\n" +
                " \n" +
                " RETURN 3.14 * r * r * h / 3;\n" +
                " \n" +
                " END\n" +
                "$$";

        st.execute(sql2);
        CallableStatement cst2 = con.prepareCall("{? = call koniHacmi(?, ?)}");
        cst2.registerOutParameter(1, Types.NUMERIC);
        cst2.setInt(2,1);
        cst2.setInt(3,1);
        cst2.execute();
        System.out.println(cst2.getBigDecimal(1));


        con.close();
        st.close();
    }
}

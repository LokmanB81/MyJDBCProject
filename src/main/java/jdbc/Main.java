package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ///DBWork objesi olustur
        DBWork db=new DBWork();
        //connection fonksiyonu cagir
       Connection con= db.connect_to_db("techproed","postgres","72653421Lb");
//yeni table olusturma metodu cagir
        db.create_table(con,"employee");




    }
}

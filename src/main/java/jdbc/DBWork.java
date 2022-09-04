package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// postgre baglanti metodu
public class DBWork {

    public Connection connect_to_db(String dbName,String user,String password){
        Connection con=null;
        try {
            Class.forName("org.postgresql.Driver");
             con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbName,user,password);
            if(con!=null){
                System.out.println("Baglanti Saglandi");
            }
            else{
                System.out.println("Baglanti Saglanamadi");
            }
        } catch (Exception e) {
            System.out.println(e);
                    }
return con;
    }

    // yeni table oulsturma metodu
    public void create_table(Connection con,String tableName){
        Statement statement;
        try {
            String query="create table "+tableName+"(empId serial,name varchar(200),email varchar(200),salary INTEGER,primary key(empId))";
              statement=con.createStatement();
              statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);

        }




    }

}

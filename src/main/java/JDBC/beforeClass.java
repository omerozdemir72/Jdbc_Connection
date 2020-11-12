package JDBC;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class beforeClass {
    Connection connection ;
    Statement statement ;
    @BeforeTest
    public void before() throws SQLException {

            String URL = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
            // Veritabanına ulaşabilmek için JDBC ye : db nini tipi (mysql), db nin yolu (test.medis.mersys.io)
            // db nin bulunduğu bilgisayarın içindeki mysql db nin port numarası (33306) ve db nin adı verildi.
            String username = "technostudy";
            String password = "zhTPis0l9#$&";

             connection= DriverManager.getConnection(URL,username,password);
   statement=  connection.createStatement(); //sorguları çalıştırabilmek

        }

        @AfterTest
    public void closeConnection() throws SQLException {

        connection.close();
        }

        @AfterMethod
        public void afterMethod(){
            System.out.println(" ///////////// ---------------- ///////////////////");
        }

        @Test
    public void test1() throws SQLException {

            ResultSet rs = statement.executeQuery("select * from language");

        rs.next();

        String name = rs.getString("name");
            System.out.println(name);
            rs.next();

           name = rs.getString("name");
            System.out.println(name);rs.next();

             name = rs.getString("name");
            System.out.println(name);

        }
    @Test
    public void test2() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

      rs.next();

        String name = rs.getString(1);
        System.out.println(name);
        rs.next();

        name = rs.getString(2);
        System.out.println(name);
        rs.next();

        name = rs.getString(2);
        System.out.println(name);

    }
    @Test
    public void test3() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();  //english yazdı

        String name = rs.getString(2);
        System.out.println(name);
        rs.next(); //itallian

        name = rs.getString(2);
        System.out.println(name);
        rs.previous();

        name = rs.getString(2);
        System.out.println(name);

    }
    @Test
    public void test4() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from film");

    rs.absolute(2);//nokta atışı yapar
    String title= rs.getString("title");
        System.out.println(title);


        rs.relative(5); //en son durdugu yerden 5 ileri

        title = rs.getString("title");
        System.out.println(title);

    }
}

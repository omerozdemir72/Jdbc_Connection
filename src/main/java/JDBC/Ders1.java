package JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class Ders1 {

   @Test
    public void test1() throws SQLException {
       String URL = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
       // Veritabanına ulaşabilmek için JDBC ye : db nini tipi (mysql), db nin yolu (test.medis.mersys.io)
       // db nin bulunduğu bilgisayarın içindeki mysql db nin port numarası (33306) ve db nin adı verildi.
       String username = "technostudy";
       String password = "zhTPis0l9#$&";

      Connection connection = DriverManager.getConnection(URL,username,password);
      Statement statement = connection.createStatement(); //sorguları çalıştırabilmek

ResultSet resultSet=      statement.executeQuery("select * from actor");    //çalıştırdık ve resultSet e eşitledik.


       resultSet.next();
String firstName= resultSet.getString("first_name");
       System.out.println(firstName);


       String lastName=resultSet.getString("last_name");
       System.out.println(lastName);
       resultSet.next();//bir sonraki satıra geçiriyor
     firstName= resultSet.getString("first_name");
       System.out.println(firstName);


       lastName=resultSet.getString("last_name");
       System.out.println(lastName);


   }
}

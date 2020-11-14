package JDBC;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class Sorular {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @BeforeTest
    public void connection() throws SQLException {
        String URL = "jdbc:mysql://test.medis.mersys.io:33306/company";
        String username = "technostudy";
        String password = "zhTPis0l9#$&";
        connection = DriverManager.getConnection(URL, username, password);
        statement = connection.createStatement();
  //      resultSet = statement.executeQuery("select * from countries");


    }

    @Test
    public void ulkeisimleri() throws SQLException {

        while (resultSet.next()) {

            String country_name = resultSet.getString("COUNTRY_NAME");

            System.out.println(country_name);
        }
    }

    @Test
    public void soru2() throws SQLException {

        while (resultSet.next()) {
            String country_name = resultSet.getString("COUNTRY_NAME");
            String country_id = resultSet.getString("COUNTRY_ID");
            System.out.println(country_name + "|" + country_id);
        }

    }

    @Test
    public void soru3() throws SQLException {

        int count =0;

        while (count<10){
            resultSet.next();
            String name = resultSet.getString(2);
            if (name.contains("e")){
                System.out.println(name.toUpperCase());
            }else
                System.out.println(name);
            count++;
        }

        }

    @Test
    public void soru4() throws SQLException {
        resultSet = statement.executeQuery("select * from countries  WHERE COUNTRY_NAME LIKE '%a'");

        while (resultSet.next()) {
            String country_name = resultSet.getString("COUNTRY_NAME");
            System.out.println(country_name);
           Assert.assertEquals(country_name.substring(country_name.length() - 1), "a");
        }


    }

        }



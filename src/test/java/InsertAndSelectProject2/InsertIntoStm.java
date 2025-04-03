package InsertAndSelectProject2;

import com.mysql.cj.PreparedQuery;
import com.mysql.cj.jdbc.CallableStatementWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertIntoStm {
    public static void inserIntoQuery(String fullName,String gender,
                                      int Age,long phone,String email,
                                      String Address) {
        try {

            final String DB_URL = "jdbc:mysql://localhost:3306/DB_Employees";
            final String DB_USERNAME = "root";
            final String DB_PASSWORD = "1234";

            Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            String sql ="Insert Into employees23(Full_Name,Gender,Age,Phone_No,Email,Address)"+"Values(?,?,?,?,?,?)";

           PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,fullName);
            statement.setString(2,gender);
            statement.setInt(3,Age);
            statement.setDouble(4,phone);
            statement.setString(5,email);
            statement.setString(6,Address);

            statement.executeUpdate();
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        inserIntoQuery("Tigist Baba",
                "Female",45,251141338,
                "tigist@gmail.com","123 Kazanchis");

        inserIntoQuery("Anani Armachen",
                "Male",19,251123586,
                "anani@gmail.com","456 Merkato");
    }
    }

package SQLQuerries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertIntoTable {

    public static void insertIntoEmployee(String fullName, String gender,
                                  String age, String email,
                                  String phone, String address) {
        final String DB_URL = "jdbc:mysql://localhost:3306/for_java_test";
        final String USERNAME = "root";
        final String PASSWORD = "1234";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO employees22(Employee_Name,Gender,Age,Email,Phone,Address)" + "VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, gender);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, address);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
        }

    catch(Exception e){
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        insertIntoEmployee("Mekdes Tassew","Female","46",
                "mekdes@gmail.com","9888985",
                "4546 Kara");
        insertIntoEmployee("Belete Kebede","Male","56","kebede@gmail.com","8888999","4565 Kotebe");
    }


}

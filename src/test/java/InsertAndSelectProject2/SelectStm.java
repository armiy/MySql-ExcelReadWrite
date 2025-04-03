package InsertAndSelectProject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SelectStm {

    public static void selectQuery(){

        try{
            final String DB_URL = "jdbc:mysql://localhost:3306/DB_Employees";
            final String DB_USERNAME = "root";
            final String DB_PASSWORD = "1234";
            Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            String sql ="Select * From employees23";

           PreparedStatement statement = connection.prepareStatement(sql);
           //Statement statement = connection.createStatement(sql);
            //final var resultSet = statement.executeQuery();// have the same result
            final var resultSet = statement.executeQuery();
            final var metaData = resultSet.getMetaData();


            for(int j=1;j<=metaData.getColumnCount();j++){
                System.out.print(metaData.getColumnName(j)+" ");
            }
            System.out.println();

            while(resultSet.next()){
                for(int i=1; i<= metaData.getColumnCount();i++){
                    System.out.print(resultSet.getObject(i)+" ");
                }
                System.out.println();
            }
            statement.close();
            connection.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
       selectQuery();
    }

}

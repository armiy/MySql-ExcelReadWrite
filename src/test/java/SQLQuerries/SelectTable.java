package SQLQuerries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SelectTable {
    //Select statement - doesnot need any argument to pass unlike insertinto
    public static void selectStatment() {
        final String DB_URL = "jdbc:mysql://localhost:3306/for_java_test";
        final String DB_UserName = "root";
        final String DB_UserPassword = "1234";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_UserName, DB_UserPassword);
            Statement stm = conn.createStatement();
            String sql = "Select * From employees22";
            final var resultSet = stm.executeQuery(sql);
            final var metaData = resultSet.getMetaData();

            for(int j=1;j<=metaData.getColumnCount();j++){
                System.out.print(metaData.getColumnName(j)+"  ");
            }
            System.out.println();

            while(resultSet.next()){
                for(int i=1;i<=metaData.getColumnCount();i++){
                    System.out.print(resultSet.getObject(i)+" ");
                }
                System.out.println();
            }

            stm.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        selectStatment();
    }
}

package com.tarnet.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionManager.ConnectionUrl = "jdbc:h2:~/tarnet";
        ConnectionManager.UserName = "sa";
        ConnectionManager.Password = "123456";

        // STEP 3. CREATING A STATEMENT // QUERY EXECUTION
        Statement statement = ConnectionManager.getConnection().createStatement(); // STATEMENT FACTORY METHOD

        // STEP 4. EXECUTE STATEMENT / QUERY
        ResultSet rs = statement.executeQuery("SELECT * FROM EMPLOYEE");
        System.out.printf("ID   FIRSTNAME   LASTNAME    SALARY%n");

        // STEP 5. GETTING RESULTS
        while (rs.next()){
            System.out.printf("%d   %s   %s    %f%n",
                    rs.getInt(1),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getDouble("SALARY"));
        }

        // STEP 6. CLOSE CONNECTION
        ConnectionManager.getConnection().close();

    }
}

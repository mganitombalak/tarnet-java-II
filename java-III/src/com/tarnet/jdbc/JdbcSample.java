package com.tarnet.jdbc;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.time.LocalDateTime;

public class JdbcSample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionManager.ConnectionUrl = "jdbc:h2:~/tarnet";
        ConnectionManager.UserName = "sa";
        ConnectionManager.Password = "123456";
//
//        // STEP 3. CREATING A STATEMENT // QUERY EXECUTION
//        Statement statement = ConnectionManager.getConnection().createStatement(); // STATEMENT FACTORY METHOD
//
//        // STEP 4. EXECUTE STATEMENT / QUERY
//        ResultSet rs = statement.executeQuery("SELECT * FROM EMPLOYEE");
//        System.out.printf("ID%-10sFIRSTNAME%-10sLASTNAME%-10sSALARY%n","","","","");

        // STEP 5. GETTING RESULTS
        // RESULT SET
//        while (rs.next()){
//                    System.out.printf("%d   %s  %s  %5.2f%n",
//                    rs.getInt(1),
//                    rs.getString("FIRSTNAME"),
//                    rs.getString("LASTNAME"),
//                    rs.getDouble("SALARY"));
//        }
// =========================================================================================================================
        // CACHEDROWSET SAMPLE OFFINE WORKING
//        CachedRowSet cachedRowSet = new CachedRowSetImpl();

//        DriverManager.registerDriver(new org.h2.Driver());
//        RowSetFactory rowSetFactory = RowSetProvider.newFactory();
//        CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
//
//        cachedRowSet.setUrl("jdbc:h2:~/tarnet");
//        cachedRowSet.setUsername("sa");
//        cachedRowSet.setPassword("123456");
//        cachedRowSet.setCommand("SELECT * FROM EMPLOYEE");
//        cachedRowSet.execute();
//
//        while (cachedRowSet.next()) {
//            if (cachedRowSet.getString("FIRSTNAME").equals("Betul")) {
//                double salary = cachedRowSet.getDouble("SALARY");
//                cachedRowSet.updateDouble("SALARY", salary * 1.1);
//            }
//            cachedRowSet.updateRow();
//            System.out.printf("%d   %s  %s  %5.2f%n",
//                    cachedRowSet.getInt(1),
//                    cachedRowSet.getString("FIRSTNAME"),
//                    cachedRowSet.getString("LASTNAME"),
//                    cachedRowSet.getDouble("SALARY"));
//        }
//        cachedRowSet.setTableName("EMPLOYEE");
//        cachedRowSet.acceptChanges();
//        System.out.println("Database updated.");

//        cachedRowSet.populate(rs);


        // TRANSACTION
        Statement genericStatement = ConnectionManager.getConnection().createStatement();
        Savepoint firstSP = null;
        Savepoint secondSP = null;
        try {
            String updateStatement = "UPDATE EMPLOYEE SET FIRSTNAME='Gani' WHERE ID=1";
            String updateStatement2 = "UPDATE EMPLOYEE SET LASTNAME='Tombalak' WHERE ID=1";

            System.out.println("Auto Commit Enabled:" + ConnectionManager.getConnection().getAutoCommit());
            ConnectionManager.getConnection().setAutoCommit(false);
            System.out.println("Auto Commit Enabled:" + ConnectionManager.getConnection().getAutoCommit());

            firstSP = ConnectionManager.getConnection().setSavepoint("FIRST_UPDATE");
            genericStatement.executeUpdate(updateStatement);

            secondSP = ConnectionManager.getConnection().setSavepoint("SECOND_UPDATE");
            genericStatement.executeUpdate(updateStatement2);

            if (LocalDateTime.now().getHour() % 2 == 0) {
                throw new SQLException("Bu sefer olmadi");
            }
        } catch (SQLException e) {
            ConnectionManager.getConnection().rollback(secondSP);
            System.out.println(e.getMessage());

        } finally {
            ConnectionManager.getConnection().commit();
            genericStatement.close();
            ConnectionManager.getConnection().close();
        }

        // STEP 6. CLOSE CONNECTION
//        ConnectionManager.getConnection().close();
    }
}

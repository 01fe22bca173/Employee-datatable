import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeInsertData {
    public static void main(String[] args) {
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // Update with your Oracle DB URL
        String mysqlUrl = "jdbc:mysql://localhost:3306/your_database"; // Update with your MySQL DB URL
        String oracleUser = "system";
        String oraclePass = "BCA5C";
        String mysqlUser = "your_mysql_user"; // Update with your MySQL user
        String mysqlPass = "your_mysql_pass"; // Update with your MySQL password

        try {
            // Insert into Oracle
            Connection oracleConn = DriverManager.getConnection(oracleUrl, oracleUser, oraclePass);
            PreparedStatement oracleStmt = oracleConn.prepareStatement("INSERT INTO Department (Did, Dname) VALUES (?, ?)");
            oracleStmt.setInt(1, 1);
            oracleStmt.setString(2, "HR");
            oracleStmt.executeUpdate();
            // Insert more departments...
            // Repeat for Employee table

            oracleStmt = oracleConn.prepareStatement("INSERT INTO Employee (Eid, Ename, Salary, address, Did) VALUES (?, ?, ?, ?, ?)");
            for (int i = 1; i <= 5; i++) {
                oracleStmt.setInt(1, i);
                oracleStmt.setString(2, "Employee" + i);
                oracleStmt.setDouble(3, 50000 + (i * 1000));
                oracleStmt.setString(4, "Address" + i);
                oracleStmt.setInt(5, 1); // Assuming all employees belong to HR
                oracleStmt.executeUpdate();
            }
            System.out.println("Oracle data inserted successfully!");
            oracleStmt.close();
            oracleConn.close();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

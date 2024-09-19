import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeCreateTable {
    public static void main(String[] args) {
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // Update with your Oracle DB URL
        String mysqlUrl = "jdbc:mysql://localhost:3306/your_database"; // Update with your MySQL DB URL
        String oracleUser = "system";
        String oraclePass = "BCA5C";
        

        try {
            // Oracle
            Connection oracleConn = DriverManager.getConnection(oracleUrl, oracleUser, oraclePass);
            Statement oracleStmt = oracleConn.createStatement();
            oracleStmt.execute("CREATE TABLE Department (Did INT PRIMARY KEY, Dname VARCHAR(50))");
            oracleStmt.execute("CREATE TABLE Employee (Eid INT PRIMARY KEY, Ename VARCHAR(50), Salary DECIMAL(10, 2), address VARCHAR(100), Did INT, FOREIGN KEY (Did) REFERENCES Department(Did))");
            System.out.println("Oracle tables created successfully!");
            oracleStmt.close();
            oracleConn.close();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

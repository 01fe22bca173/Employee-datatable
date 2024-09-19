import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDisplayData {
    public static void main(String[] args) {
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // Update with your Oracle DB URL
        String oracleUser = "system";
        String oraclePass = "BCA5C";

        try {
            Connection oracleConn = DriverManager.getConnection(oracleUrl, oracleUser, oraclePass);
            Statement stmt = oracleConn.createStatement();
            
            String query = "SELECT * FROM Employee";
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("Eid\tEname\tSalary\tAddress\tDid");
            while (rs.next()) {
                int eid = rs.getInt("Eid");
                String ename = rs.getString("Ename");
                double salary = rs.getDouble("Salary");
                String address = rs.getString("address");
                int did = rs.getInt("Did");
                System.out.printf("%d\t%s\t%.2f\t%s\t%d%n", eid, ename, salary, address, did);
            }
            
            rs.close();
            stmt.close();
            oracleConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class MyFirstJDBCExample {

    public static void main(String[] args) {
        JdbcRowSet rowSet = null;

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Create JdbcRowSet instance
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            rowSet.setUsername("SYSTEM");
            rowSet.setPassword("BCA5C");
            
            // Set SQL command to fetch data from student table
            rowSet.setCommand("SELECT * FROM student");
            rowSet.execute();

            // Iterate through the result set
            while (rowSet.next()) {
                System.out.println("Id: " + rowSet.getInt(1)); // Use 1 for the first column
                System.out.println("First Name: " + rowSet.getString("first_name"));
                System.out.println("Last Name: " + rowSet.getString("last_name"));
                System.out.println("Date of Birth: " + rowSet.getDate("date_of_birth"));
                System.out.println("Email: " + rowSet.getString("email"));
                System.out.println("Enrollment Date: " + rowSet.getDate("enrollment_date"));
                System.out.println("-----------");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close JdbcRowSet if it was created
            if (rowSet != null) {
                try {
                    rowSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

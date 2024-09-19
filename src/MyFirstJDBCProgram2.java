import java.sql.*;

public class MyFirstJDBCProgram2 {
   public static void main(String[] args) {
      String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "SYSTEM";
      String password = "BCA5C";
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection(DB_URL, user, password);
         if (con != null) {
            System.out.println("Connetion successful to Oracle DB");
         } else {
            System.out.println("Connection Failed");
         }
         // Statement stmt = con.createStatement();
         // // String sql="Create table Student(sid int primary key,sname varchar(20),city
         // // varchar(20))";
         // String insertsql = "Insert into Student values(126,'Ritul','Hubli')";
         // // int r=stmt.executeUpdate(sql);
         // int n = stmt.executeUpdate(insertsql);
         // boolean successful = stmt.execute(insertsql);
         // // ResultSet rs=stmt.executeQuery(insertsql);
         // System.err.println(n);
         // System.out.println(successful);
         // // System.out.println(rs);
         String insertSql="Insert into student values(?,?,?)";
    PreparedStatement pstmt=con.prepareStatement(insertSql);
    pstmt.setInt(1, 135);
    pstmt.setString(2, "Prateek");
    pstmt.setString(3, "Hubli");
    int r=pstmt.executeUpdate();
    System.out.println(r);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException s) {

      }
   }
   
}
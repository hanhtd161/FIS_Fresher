package fis.java.practice01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

 // Kết nối vào MySQL.
 public static Connection getMySqlConnection() throws SQLException,
         ClassNotFoundException {
     String hostName = "localhost";

     String dbName = "practice03_01";
     String userName = "root";
     String password = "hanhtd161";

     return MySQLConnUtils.getMysqlConnection(hostName, dbName, userName, password);
 }

 public static Connection getMysqlConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
     // Khai báo class Driver cho DB MySQL
     // Việc này cần thiết với Java 5
     // Java6 tự động tìm kiếm Driver thích hợp.
     // Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
     Class.forName("com.mysql.cj.jdbc.Driver");

     // Cấu trúc URL Connection dành cho Oracle
     // Ví dụ: jdbc:mysql://localhost:3306/simplehr
     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}

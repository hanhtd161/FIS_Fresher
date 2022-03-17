package fis.java.practice01;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

	  public static Connection getMyConnection() throws SQLException,
	          ClassNotFoundException {
	      // Sử dụng Oracle.
	      // Bạn có thể thay thế bởi Database nào đó.
	      return MySQLConnUtils.getMySqlConnection();
	  }

	  public static void main(String[] args) throws SQLException,
	          ClassNotFoundException {

	      System.out.println("Get connection ... ");

	      Connection conn = ConnectionUtils.getMyConnection();

	      System.out.println("Get connection " + conn);

	      System.out.println("Done!");
	  }

	}
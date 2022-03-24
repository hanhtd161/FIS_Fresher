package practice.springjdbc.demo;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import practice.springjdbc.config.AppConfiguration;
import practice.springjdbc.dao.QueryForRowSetReturnSqlRowSetDAO;

public class QueryForRowSetReturnSqlRowSet_Test {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryForRowSetReturnSqlRowSetDAO dao = context.getBean(QueryForRowSetReturnSqlRowSetDAO.class);

        // SqlRowSet
        SqlRowSet rowSet = dao.queryForRowSet_SqlRowSet();

        while (rowSet.next()) {
           
            System.out.println("-----");
            Long empId = rowSet.getLong("Emp_Id"); // Index = 1
            String empNo = rowSet.getString(2); // Index = 2
            String empName = rowSet.getString("Emp_Name"); // Index = 3

            System.out.println("EmpID: " + empId + ", EmpNo: " + empNo + ", EmpName:" + empName);
        }

    }
   
}
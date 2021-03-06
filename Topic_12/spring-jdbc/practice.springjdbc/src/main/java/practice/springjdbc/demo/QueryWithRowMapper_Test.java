package practice.springjdbc.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import practice.springjdbc.config.AppConfiguration;
import practice.springjdbc.dao.QueryWithRowMapperDAO;
import practice.springjdbc.model.Department;

public class QueryWithRowMapper_Test {

	   
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryWithRowMapperDAO dao = context.getBean(QueryWithRowMapperDAO.class);

        List<Department> list = dao.queryDepartment() ;
       
        for(Department dept: list)  {
            System.out.println("DeptNo: "+ dept.getDeptNo()+" - DeptName: "+ dept.getDeptName());
        }
  
    }
   
}

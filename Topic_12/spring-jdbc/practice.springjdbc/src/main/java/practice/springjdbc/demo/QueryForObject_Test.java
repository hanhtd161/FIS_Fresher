package practice.springjdbc.demo;

import java.util.Date;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import practice.springjdbc.config.AppConfiguration;
import practice.springjdbc.dao.QueryForObjectDAO;
import practice.springjdbc.model.Department;

public class QueryForObject_Test {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryForObjectDAO dao = context.getBean(QueryForObjectDAO.class);

        System.out.println(" ------------- ");
        Department dept = dao.getDepartment("D20");

        if (dept != null) {
            System.out.println("DeptNo: " + dept.getDeptNo() + " - DeptName: " + dept.getDeptName());
        } else {
            System.out.println("Department not found!");
        }
        System.out.println(" ------------- ");

        String deptName = dao.getDeptNameById(3L);
        System.out.println("Dept Name by Id 3: " + deptName);

        System.out.println(" ------------- ");

        Date hireDate = dao.getEmpHireDateById(2L);
        System.out.println("HireDate by EmpId 2: " + hireDate);

    }

}

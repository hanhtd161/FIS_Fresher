package practice.springjdbc.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import practice.springjdbc.config.AppConfiguration;
import practice.springjdbc.dao.QueryForListReturnListDAO;

public class QueryForListReturnList_Test {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryForListReturnListDAO dao = context.getBean(QueryForListReturnListDAO.class);

        List<String> names = dao.getDeptNames("A");

        for (String name : names) {

            System.out.println("Dept Name: " + name);
        }
    }

}


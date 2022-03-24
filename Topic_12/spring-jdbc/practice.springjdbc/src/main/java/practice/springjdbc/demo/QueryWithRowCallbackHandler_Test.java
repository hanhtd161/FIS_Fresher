package practice.springjdbc.demo;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import practice.springjdbc.config.AppConfiguration;
import practice.springjdbc.dao.QueryWithRowCallbackHandlerDAO;

public class QueryWithRowCallbackHandler_Test {

	   
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryWithRowCallbackHandlerDAO dao = context.getBean(QueryWithRowCallbackHandlerDAO.class);

        dao.queryEmployee();
    }
   
}

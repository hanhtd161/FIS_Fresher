package practice.springjdbc.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import practice.springjdbc.config.AppConfiguration;
import practice.springjdbc.dao.QueryForListReturnListMapDAO;

public class QueryForListReturnListMap_Test {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        QueryForListReturnListMapDAO dao = context.getBean(QueryForListReturnListMapDAO.class);

        // Map<String columnName, Object value)
        List<Map<String, Object>> list = dao.queryForList_ListMap2();

        for (Map<String, Object> map : list) {
            System.out.println("-----");
            for (String key : map.keySet()) {
                System.out.println("Key: " + key + " - value: " + map.get(key));
            }
        }
    }

}

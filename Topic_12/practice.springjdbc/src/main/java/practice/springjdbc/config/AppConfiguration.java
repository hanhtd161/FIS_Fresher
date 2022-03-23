package practice.springjdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"practice.springjdbc.dao","practice.springjdbc.config"})
public class AppConfiguration {
	
}
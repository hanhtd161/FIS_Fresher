//package com.fis.project.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//	
//	@Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	     auth.userDetailsService(userDetailsService);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//			.cors().and()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//			.authorizeRequests()
//			.antMatchers("/criminal-case/find-status").hasRole("CHIEF_INSPECTOR")
//			.antMatchers("/criminal-case/find-user").hasRole("INSPECTOR")
//			.antMatchers("/evidence/find/**").hasRole("SENIOR")
//			.anyRequest().authenticated();
//	}
//	
//}

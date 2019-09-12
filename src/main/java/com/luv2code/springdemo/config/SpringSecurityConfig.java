package com.luv2code.springdemo.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource myDataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//we are using jdbc authentication.....
		auth.jdbcAuthentication().dataSource(myDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		      .loginPage("/showMyLoginPage")
		      .loginProcessingUrl("/authenticateTheUser")
		      .permitAll()
		     .and()
		     .logout().permitAll();
		   
	}


	
	
}

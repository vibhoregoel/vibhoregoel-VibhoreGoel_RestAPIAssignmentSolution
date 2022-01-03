package com.greatlearning.EmployeeManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.EmployeeManagement.dao.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**", "/roles/addRole", "/users/saveUser");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
		    .antMatchers("/", "/employees/save", "/employees/sort", "/employees/403", "/roles/addRole", "/users/saveUser").hasAnyAuthority("admin", "user")
		    .antMatchers("/employees/showFormForUpdate", "/employees/delete").hasAuthority("admin")
		    .anyRequest().authenticated()
		    .and()
		    .formLogin().loginProcessingUrl("/login").successForwardUrl("/users/home").permitAll()
		    .and()
		    .logout().logoutSuccessUrl("/login").permitAll()
		    .and()
		    .exceptionHandling().accessDeniedPage("/employees/403")
		    .and()
		    .cors().and().csrf().disable();
	}
	
	
}

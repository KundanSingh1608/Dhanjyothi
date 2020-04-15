/**
 * 
 */
package com.dhanjyothi.config;

/**
 * @author KundanSingh
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	@Autowired
	private MySimpleUrlAuthenticationSuccessHandler successHandler;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests()
	    .antMatchers("/resources/**").permitAll()
	    .antMatchers("/login").permitAll()
	    .antMatchers("/user").permitAll()
	    .antMatchers("/loadaccount").permitAll()
	    .antMatchers("/signup").permitAll()
	    .antMatchers("/createsavingsaccount").permitAll()
	    .antMatchers("/loadtermaccount").permitAll()
	    .antMatchers("/viewtransactions").permitAll()
	    .antMatchers("/transferamt").permitAll()
	    .antMatchers("/loadbeneficiary").permitAll()
	    .antMatchers("/loadtransfer").permitAll()
	    .antMatchers("/beneficiarywithinbank").permitAll()
	    .antMatchers("/savebeneficiary").permitAll()
	    .antMatchers("/register/**").permitAll()
	    .antMatchers("/login/**").permitAll()
	    .antMatchers("/userListToBeEnabled").permitAll()
	    .antMatchers("/admin/**").hasAuthority("ADMIN")
	    .anyRequest().authenticated()
	    .and()
	    .formLogin()
	    .loginPage("/login").loginProcessingUrl("/login/submit")
		.usernameParameter("userName")
		.passwordParameter("password")
	    .successHandler(successHandler)
	    .failureUrl("/login?error")
		.and()
		.logout().logoutSuccessUrl("/login?logout")
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}


package com.te.blog.blogexeception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class BlogSpringSecurity {
	
	@Autowired
	private AccountAuthenticationProvider accountAuthenticationProvider;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder=http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(accountAuthenticationProvider);
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/admin/userregister", "/user/login","/viewer/**").permitAll()
		.anyRequest()
		.hasAnyRole("user","admin")
		.and()
		.httpBasic(Customizer.withDefaults())
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}
//	
//	 @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	        return encoder;
//	    }

	
}











































//import org.springframework.beans.factory.annotation.Autowired;

//import com.te.blog.servicesimp.ServicesImp;

//import org.springframework.beans.factory.annotation.Autowired;
	//import org.springframework.context.annotation.Bean;
	//import org.springframework.context.annotation.Configuration;
	//import org.springframework.security.authentication.AuthenticationProvider;
	//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
	//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
	//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
	//import org.springframework.security.core.userdetails.UserDetailsService;
	//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	//
	//@SuppressWarnings("deprecation")
	//@Configuration
	//@EnableWebSecurity
	//@EnableGlobalMethodSecurity(prePostEnabled = true) // its req when we using @PreAuthorized("hasRole('ADMIN')")
//public class BlogSpringSecurity {
	//@Autowired
	//private ServicesImp servicesImp;
	//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable();
//			http.authorizeRequests().antMatchers("/login").permitAll();
//			http.authorizeRequests().antMatchers("/controler/**").hasRole("ADMIN");
//			http.authorizeRequests().antMatchers("/crud/**").hasAnyRole("USER", "ADMIN").anyRequest()
//					.authenticated().and().httpBasic();
//		}
	//
//		@Bean
//		AuthenticationProvider authenticationProvider() {
//			DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//			daoAuthenticationProvider.setUserDetailsService(userdetailsService);
//			daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//			return daoAuthenticationProvider;
//		}
	//}

//}

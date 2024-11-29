package com.iktpreobuka.stepal.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig {

	@Autowired
	private org.springframework.security.web.AuthenticationEntryPoint authenticationEntryPoint;

	@SuppressWarnings({ "removal" })
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic()
				.authenticationEntryPoint(authenticationEntryPoint);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
		auth
			.inMemoryAuthentication()
			.withUser("admin").password("{noop}admin14993").roles("ADMIN")
			.and()
    		.withUser("vlasnik").password("{noop}markoStep").roles("VLASNIK");
    		
		   
 
		return auth.build();
	}

	// ---------------------------------------------------------------------------

	@Value("${spring.security.user.name}")
	private String username;

	@Value("${spring.security.user.password}")
	private String password;

	

	@SuppressWarnings({ "removal" })

	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()
	            .authorizeRequests()
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .requestMatchers("/dobavljaci/**", "/materijal/**", "/proizvodi/**", "/radnici/**", "/vlasnik/**").hasAnyRole("ADMIN","VLASNIK")
	                .requestMatchers("/dobavljaci/add", "/dobavljaci/update/**", "/dobavljaci/delete/**",
	                             "/materijal/create", "/materijal/update/**", "/materijal/delete/**",
	                             "/proizvodi/create", "/proizvodi/update/**", "/proizvodi/delete/**",
	                             "/radnici/create", "/radnici/update/**", "/radnici/delete/**",
	                             "/vlasnik/create", "/vlasnik/update/**","/vlasnik/delete/**").hasAnyRole("ADMIN", "VLASNIK")
	                .anyRequest().authenticated()
	                .and()
	            .httpBasic()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .permitAll()
	                .and()
	            .logout()
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/logout?logout")
	                .permitAll();
	    }
}
	
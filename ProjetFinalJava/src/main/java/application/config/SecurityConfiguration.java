package application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import application.services.AuthService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthService authService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**", "/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.antMatcher("/api/**")
				.csrf().ignoringAntMatchers("/api","/api/**")
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.OPTIONS).anonymous()
					
					.antMatchers(HttpMethod.POST,"/api/rencontre","/api/rencontre/**").hasRole("USER")
					.antMatchers(HttpMethod.GET,"/api/rencontre","/api/rencontre/**").authenticated()
					.antMatchers(HttpMethod.DELETE,"/api/rencontre","/api/rencontre/**").hasAnyRole("USER","ADMIN")
					
					.antMatchers(HttpMethod.POST,"/api/inscription","/api/inscription/**").authenticated()
					.antMatchers(HttpMethod.GET,"/api/inscription","/api/inscription/**").authenticated()
					.antMatchers(HttpMethod.DELETE,"/api/inscription","/api/inscription/**").hasAnyRole("USER","ADMIN")
					
					.antMatchers(HttpMethod.POST,"/api/joueur","/api/joueur/**").anonymous()
					.antMatchers(HttpMethod.GET,"/api/joueur","/api/joueur/**").authenticated()
					.antMatchers(HttpMethod.DELETE,"/api/joueur","/api/joueur/**").hasAnyRole("ADMIN")
					
					.antMatchers(HttpMethod.GET,"/api/compte/user").authenticated()
				.and()
				.httpBasic();
		// @formatter:on


	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("toto").password("{noop}toto").roles("ADMIN");
		//		auth.inMemoryAuthentication().withUser("lolo").password("{noop}lolo").roles("USER");

		auth.userDetailsService(authService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

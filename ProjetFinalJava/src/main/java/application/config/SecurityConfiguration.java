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
//					.antMatchers("/api/fournisseur","/api/fournisseur/**").hasRole("ADMIN")
					.antMatchers(HttpMethod.POST,"/api/**").anonymous()
//					.antMatchers("/api/commande","/api/commande/**").authenticated()
//					.antMatchers(HttpMethod.POST,"/api/client").anonymous()
//					.antMatchers(HttpMethod.POST,"/api/produit").hasRole("ADMIN")
//					.antMatchers(HttpMethod.PUT,"/api/produit/**").hasRole("ADMIN")
//					.antMatchers(HttpMethod.DELETE,"/api/produit/**").hasRole("ADMIN")
					.antMatchers("/api","/api/**").authenticated()
				.and()
				.httpBasic()
			.and()		
			.antMatcher("/**")
				.authorizeRequests()
//					.antMatchers("/","/rencontre/**","/compte/inscription","/client/save").permitAll()
//					.antMatchers("/client/histo","/client/histo/details").authenticated()
//					.antMatchers("/produit","/produit/**","/client","/client/**").hasAnyRole("ADMIN")
//					.antMatchers("/fournisseur","/fournisseur/**").hasAnyRole("ADMIN")
					.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/")
					.failureUrl("/login?error")
					.permitAll()
				.and()	
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/?logout");
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

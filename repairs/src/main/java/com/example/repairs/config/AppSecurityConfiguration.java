package com.example.repairs.config;

import com.example.repairs.entities.UserRoles;
import com.example.repairs.repositories.UserRepository;
import com.example.repairs.services.impl.AppUserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;


@Configuration
public class AppSecurityConfiguration {
	private UserRepository userRepository;

	public AppSecurityConfiguration(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityContextRepository securityContextRepository) throws Exception {
		http
				.authorizeHttpRequests(
						authorizeHttpRequests ->
								authorizeHttpRequests.
										requestMatchers(PathRequest.toStaticResources().atCommonLocations())
										.permitAll()
										.requestMatchers("/favicon.ico").permitAll()
										.requestMatchers("/error").permitAll()
										.requestMatchers("/",
												"cart/add", "/add/{name}", "/product/add/{name}",
												"/add/{repairPartsId}", "/product/{name}",
												"product/p/{categoryName}",
												"product/products", "/users/login",
												"/users/edit", "/users/register", "/users/login-error", "cart/user")
										.permitAll().
										requestMatchers("/users/profile", "/order/user", "customers/edit", "/users/logout").authenticated().
										requestMatchers("/admin",
												"/admin/categories/create",
												"/admin/cars/create",
												"/admin/repair/create").hasAnyRole(UserRoles.MODERATOR.name(), UserRoles.ADMIN.name()).
										anyRequest().authenticated()
				)
				.formLogin(
						(formLogin) ->
								formLogin.
										loginPage("/users/login").
										usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
										passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
										defaultSuccessUrl("/").
										failureForwardUrl("/users/login-error")
				)
				.logout((logout) ->
						logout.logoutUrl("/users/logout").
								logoutSuccessUrl("/").
								invalidateHttpSession(true)
				).securityContext(
						securityContext -> securityContext.
								securityContextRepository(securityContextRepository)
				);

		return http.build();
	}

	@Bean
	public SecurityContextRepository securityContextRepository() {
		return new DelegatingSecurityContextRepository(
				new RequestAttributeSecurityContextRepository(),
				new HttpSessionSecurityContextRepository()
		);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new AppUserDetailsServiceImpl(userRepository);
	}
}


package com.sunchips.apiv1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/", "/login","/login/oauth2/code/spotify", "/oauth2/authorization/my-oidc-client", "/me", "/token").permitAll()
				.anyRequest().authenticated()
			)
			.oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/me", true)); // use oauth2Login for interactive login
			// .oauth2Client(Customizer.withDefaults());
		return http.build();
	}

}

package com.sesi.login.config;

import java.beans.JavaBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class configuracaoSeguranca {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity htpp) throws Exception{
		htpp.authorizeHttpRequests((authorize) ->
		authorize
			.requestMatchers("/login","/registrar").permitAll()
			.anyRequest().authenticated()
			.formLogin((form)->
			form
			.loginpage("/login")
			.defaultSuccessUrl("/home",true))
			
				);
		
		return htpp.build();
	}
}

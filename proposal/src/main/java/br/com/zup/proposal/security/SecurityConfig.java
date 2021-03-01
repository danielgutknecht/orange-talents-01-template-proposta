package br.com.zup.proposal.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("Realizando as configurações de autenticação");
		http.authorizeRequests(authorize -> authorize.antMatchers(HttpMethod.POST, "/proposals/**").hasAuthority("SCOPE_propostas:write")
				.antMatchers(HttpMethod.GET, "/proposals/**").hasAuthority("SCOPE_propostas:read")
//                        .antMatchers(HttpMethod.GET,"/actuator/**").hasAuthority("SCOPE_propostas:read")
				.antMatchers(HttpMethod.POST, "/biometrics/**").hasAuthority("SCOPE_propostas:write")
				.antMatchers(HttpMethod.POST, "/cards/**").hasAuthority("SCOPE_propostas:write")
				.antMatchers(HttpMethod.POST, "/wallets/**").hasAuthority("SCOPE_propostas:write")
				.antMatchers(HttpMethod.POST, "/travels/**").hasAuthority("SCOPE_propostas:write")
				.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
				.anyRequest()
				.denyAll())
				.csrf()
				.disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
				"/swagger-resources/**");
	}

}

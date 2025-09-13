package com.sarathi.hotserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter.HeaderValue;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //source https://docs.spring.io/spring-security/reference/servlet/exploits/headers.html
        http.cors(cors -> cors.disable()).csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                                .maximumSessions(5)
                                .maxSessionsPreventsLogin(true)
                )
                .authorizeHttpRequests(requests -> requests
                                .requestMatchers(HttpMethod.GET).permitAll()
                                .requestMatchers(HttpMethod.POST).permitAll()
                                .requestMatchers(HttpMethod.PUT).permitAll()
                                .requestMatchers(HttpMethod.DELETE).permitAll()
                                .requestMatchers("/lib/**").permitAll()
                )
                .headers(headers -> headers
                                .frameOptions(frameOptions -> frameOptions.sameOrigin())
                                .httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true)
                                                .preload(true)
                                                .maxAgeInSeconds(31536000)
                                )
                                .contentTypeOptions(contentTypeOptions -> contentTypeOptions.disable())
                                .xssProtection(xss -> xss.headerValue(HeaderValue.ENABLED_MODE_BLOCK))
                                /*.contentSecurityPolicy(csp -> csp
                                        .policyDirectives(
                                            "form-action 'self'; script-src 'self' 'unsafe-inline' 'unsafe-eval'; "
                                                + "style-src 'self' 'unsafe-inline' fonts.googleapis.com; "
                                                + "style-src-elem 'self' 'unsafe-inline' fonts.googleapis.com; " 
                                                + "object-src 'self'; " + "connect-src 'self'; "  + "img-src 'self' data:; "
                                                + "frame-src 'none'; " + "frame-ancestors 'none'; " + "media-src 'self'; "
                                                + "manifest-src 'self'; " + "prefetch-src 'self'; "
                                                + "font-src 'self' data: fonts.gstatic.com;")
                                    )*/
                                .referrerPolicy(referrer -> referrer.policy(ReferrerPolicy.SAME_ORIGIN))
                                .permissionsPolicy(permissions -> permissions.policy("geolocation=(self)"))

                );

	    return http.build();
	}


    @Bean
    WebSessionIdResolver webSessionIdResolver() {
        CookieWebSessionIdResolver resolver = new CookieWebSessionIdResolver();
        resolver.setCookieName("JSESSIONID");
        resolver.addCookieInitializer((builder) -> {
            builder.path("/")
                    .httpOnly(true)
                    .secure(true)//.domain("solution.wb.gov.in")
                    .sameSite("None; Secure");
        });
        return resolver;
    }
    

	
	@Bean
	MultipartResolver multipartResolver() {
	    return new StandardServletMultipartResolver();
	}

}

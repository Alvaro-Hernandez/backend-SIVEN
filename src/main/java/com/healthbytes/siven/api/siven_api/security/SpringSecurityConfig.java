package com.healthbytes.siven.api.siven_api.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.healthbytes.siven.api.siven_api.security.filter.JwtAuthenticationFilter;
import com.healthbytes.siven.api.siven_api.security.filter.JwtValidationFilter;

@Configuration
// @EnableMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(
                (requests) -> requests
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/usuarios/list-users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/v1/usuarios/register-user").permitAll()
                        .requestMatchers(HttpMethod.POST, "/v1/usuarios/create-user").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/v1/catalogo/red-servicio/create-silais").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/v1/catalogo/red-servicio/update-silais/{id_silais}")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/v1/catalogo/red-servicio/list-silais")
                        .hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers(HttpMethod.GET, "/v1/catalogo/red-servicio/silais/{id_sialis}")
                        .hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers(HttpMethod.DELETE, "/v1/catalogo/red-servicio/delete-silais/{id_sialis}")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/v1/catalogo/red-servicio/list-establecimientos")
                        .hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers(HttpMethod.GET,
                                "/v1/catalogo/red-servicio/establecimiento/{id_establecimiento}")
                        .hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers(HttpMethod.POST, "/v1/catalogo/red-servicio/create-establecimiento")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,
                                "/v1/catalogo/red-servicio/update-establecimiento/{id_establecimiento}")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,
                                "/v1/catalogo/red-servicio/delete-establecimiento/{id_establecimiento}")
                        .hasRole("ADMIN")
                        .requestMatchers("/v1/catalogo/captacion/**").hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers("/v1/catalogo/escuela/**").hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers("/v1/catalogo/jornadas/**").hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers("/v1/catalogo/medicamentos/**").hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers("/v1/catalogo/tiposeguimiento/**").hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .requestMatchers("/v1/catalogo/persona/**").hasAnyRole("ADMIN", "EPIDEMIOLOGO")
                        .anyRequest()
                        .authenticated())
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtValidationFilter(authenticationManager()))
                .csrf(config -> config.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(management -> management.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))
                .build();
    }

    // Manejo de cors para los clientes
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(
                new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}

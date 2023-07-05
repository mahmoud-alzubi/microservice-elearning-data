package com.mtech.elearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((request) -> request
                .requestMatchers(HttpMethod.GET, "/api/instructor-details", "/api/instructor-details/**",
                        "/api/courses", "/api/courses/**", "/api/instructors", "/api/instructors/**")
                .hasAnyRole("STUDENT", "EMPLOYEE", "MANAGER", "ADMIN")

                .requestMatchers(HttpMethod.GET, "/api/students", "/api/students/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/reviews", "/api/reviews/**").hasAnyRole( "MANAGER", "ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/instructor-details", "/api/instructor-details/**",
                        "/api/courses", "/api/courses/**", "/api/instructors", "/api/instructors/**", "/api/students", "/api/students/**")
                .hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/reviews", "/api/reviews/**").hasAnyRole("STUDENT")

                .requestMatchers(HttpMethod.PUT, "/api/instructor-details", "/api/instructor-details/**",
                        "/api/courses", "/api/courses/**", "/api/instructors", "/api/instructors/**", "/api/students", "/api/students/**")
                .hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/api/instructor-details", "/api/instructor-details/**",
                        "/api/courses", "/api/courses/**", "/api/instructors", "/api/instructors/**", "/api/students", "/api/students/**",
                        "/api/reviews", "/api/reviews/**").hasAnyRole("MANAGER", "ADMIN")

        );

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }


}

package com.hadicha.projectfortylines.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Doctor").password("doctor").roles("DOCTOR");
        auth.inMemoryAuthentication().withUser("MainDoctor").password("maindoctor").roles("MAINDOCTOR");
        auth.inMemoryAuthentication().withUser("MedicalSister").password("medicalsister").roles("MEDICALSISTER");
        auth.inMemoryAuthentication().withUser("Patient").password("patient").roles("PATIENT");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("MAINDOCTOR").anyRequest().fullyAuthenticated().and()
                .httpBasic();

    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}

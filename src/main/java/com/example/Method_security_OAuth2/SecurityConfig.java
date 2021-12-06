package com.example.Method_security_OAuth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("wwowann").password(passwordEncoder.encode("12345")).roles("READ")
                .and().withUser("Vasi").password(passwordEncoder.encode("11111")).roles("WRITE")
                .and().withUser("Oleg").password(passwordEncoder.encode("11111")).roles("DELETE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()//аутентификация происходит автоматически, если эндпоинт /authorize
//                .authorizeRequests().antMatchers("/authorize").permitAll()
//                .and()//аутентификация происходит автоматически, если эндпоинт /authorize2
//                .authorizeRequests().antMatchers("/authorize2").permitAll()
//                .and()//все остальные вхождения через форму авторизации
                .authorizeRequests().anyRequest().authenticated();
    }
}

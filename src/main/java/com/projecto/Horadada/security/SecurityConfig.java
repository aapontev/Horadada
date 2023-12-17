package com.projecto.Horadada.security;

import com.projecto.Horadada.service.Imp.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private BCryptPasswordEncoder codificador;

    @Autowired
    private SecurityService securityService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(codificador);
    }
@Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf((csrf) -> csrf
                    .disable())
                .authorizeRequests()
                //.requestMatchers("/principal").authenticated()
                //.antMatchers("/consulta**").authenticated()
                .requestMatchers("/consulta").hasRole("ADMIN")
                /*.antMatchers("/medicoMantenimiento").hasRole("ADMIN")
                .antMatchers("/pacienteMantenimiento").hasRole("ADMIN")
                .antMatchers("/usuarioMantenimiento").hasRole("ADMIN")*/
                .requestMatchers("/login*").permitAll()
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/index")
                    .permitAll()
                    .failureUrl("/login?error=true")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                .logout()
                    .permitAll();
        return http.build();
    }
}

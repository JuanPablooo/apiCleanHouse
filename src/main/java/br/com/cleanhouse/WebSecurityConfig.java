package br.com.cleanhouse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/login/usuario").permitAll()
                .antMatchers("/v1/clientes").permitAll()
                .antMatchers("/v1/profissionais").permitAll()
                .antMatchers(HttpMethod.POST, "/login/usuario").permitAll()
                .antMatchers(HttpMethod.POST, "/v1/clientes").permitAll()
                .antMatchers(HttpMethod.POST, "/v1/profissionais").permitAll()
                .anyRequest().authenticated()
                .and()

                .addFilterBefore(new JWTLoginFilter("/login/usuario", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)

                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
            .withUser("admin")
                .password("password")
                .roles("ADMIN");

    }
}


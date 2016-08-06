package me.zacharyjia.fuckexcel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by zachary on 16/7/30.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/static/**").permitAll()
//                    .antMatchers("/login", "/doLogin").permitAll()
                    .antMatchers("/sa/**").hasRole("SA")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasRole("USER")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/doLogin")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true);
    }
}

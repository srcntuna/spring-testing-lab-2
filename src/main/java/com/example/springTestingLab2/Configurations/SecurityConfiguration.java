package com.example.springTestingLab2.Configurations;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static javax.management.Query.and;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfiguration  {



    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//                        .anyRequest()
//                        .permitAll();

        log.trace("in SecurityFilterChain");

        http.authorizeRequests()
                .antMatchers("/getPrice")
                .authenticated()
                .and()
                .formLogin()
                .and() // add to the chain
                .logout(); // request a logout form


        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();




        log.trace("out SecurityFilterChain");

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {

        log.trace("in userDetailsService");

        InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();

        UserDetails user1 = User.withUsername("user")
                .password(passwordEncoder().encode("test"))
                .authorities("read")
                .build();
        userDetailService.createUser(user1);

        UserDetails adminUser1 = User.withUsername("admin")
                .password(passwordEncoder().encode("test"))
                .authorities("admin")
                .build();
        userDetailService.createUser(adminUser1);

        log.trace("out userDetailService");

        return userDetailService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {

        log.trace("in passwordEncoder");
        log.trace("creating passwordEncoder");
        return new BCryptPasswordEncoder();
    }




}
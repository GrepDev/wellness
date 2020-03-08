package com.wellness.security;

import com.wellness.role.Authorizations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/login/admin/**").hasAuthority(Authorizations.ADMIN.toString())
                .antMatchers("/login/trainer/**").hasAuthority(Authorizations.TRAINER.toString())
                .antMatchers("/login/customer/**").hasAuthority(Authorizations.CUSTOMER.toString())
                .antMatchers("/login/**")
                .authenticated();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("customer").password("password").authorities(Authorizations.CUSTOMER.toString()).build());
        manager.createUser(users.username("admin").password("password").authorities(Authorizations.TRAINER.toString(), Authorizations.CUSTOMER.toString(),Authorizations.ADMIN.toString()).build());
        manager.createUser(users.username("trainer").password("password").authorities(Authorizations.TRAINER.toString()).build());
        return manager;

    }
}

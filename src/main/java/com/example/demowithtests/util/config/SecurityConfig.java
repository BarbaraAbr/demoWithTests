package com.example.demowithtests.util.config;

import com.example.demowithtests.domain.Permission;
import com.example.demowithtests.domain.Role;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // TODO: 18-Oct-22 Create 2 users for demo
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//
//    }

    // TODO: 18-Oct-22 Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/users/**").hasAuthority(Permission.USERS_GET.getPermission())
//                .antMatchers(HttpMethod.POST, "/api/users").hasAuthority(Permission.USERS_POST.getPermission())
//                .antMatchers(HttpMethod.PUT, "/api/users/**").hasAuthority(Permission.USERS_PUT.getPermission())
//                .antMatchers(HttpMethod.PATCH, "/api/users/**").hasAuthority(Permission.USERS_PATCH.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/api/users/**").hasAuthority(Permission.USERS_DELETE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
                //.formLogin().disable();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .authorities(Role.ADMIN.getAuthorities())
                        .build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user"))
                        .authorities(Role.USER.getAuthorities())
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}

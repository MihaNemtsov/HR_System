package com.nemez.company.hrsystem.config;

import com.nemez.company.hrsystem.security.jwt.JwtConfigurer;
import com.nemez.company.hrsystem.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/admin/**";
    private static final String LOGIN_ENDPOINT = "/auth/login";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
                .antMatchers("/post/create").hasAnyRole("ADMIN", "MODERATOR")
                .antMatchers("/post/read/**").hasAnyRole("ADMIN", "MODERATOR", "USER")
                .antMatchers("/post/update/**").hasAnyRole("ADMIN", "MODERATOR")
                .antMatchers("/post/delete/**").hasAnyRole("ADMIN")
                .antMatchers("/department/create").hasAnyRole("ADMIN", "MODERATOR")
                .antMatchers("/department/read/**").hasAnyRole("ADMIN", "MODERATOR", "USER")
                .antMatchers("/department/update/**").hasAnyRole("ADMIN", "MODERATOR")
                .antMatchers("/department/delete/**").hasAnyRole("ADMIN")
                .antMatchers("/men/create").hasAnyRole("ADMIN", "MODERATOR")
                .antMatchers("/men/read/**").hasAnyRole("ADMIN", "MODERATOR", "USER")
                .antMatchers("/men/update/**").hasAnyRole("ADMIN", "MODERATOR")
                .antMatchers("/men/delete/**").hasAnyRole("ADMIN")
                .antMatchers("/users/**").hasRole("USER")
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}

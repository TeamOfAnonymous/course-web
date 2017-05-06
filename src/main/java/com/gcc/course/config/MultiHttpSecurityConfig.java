package com.gcc.course.config;

import com.gcc.course.security.JwtAuthenticationEntryPoint;
import com.gcc.course.security.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by huangMP on 2017/5/6.
 * decription :
 */
@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

        // 静态资源访问的 url
        private String[] staticFileUrl = {"/css/**","/fonts/**","/img/**","/js/**","/url/**","/vendor/**"};
        // 不用认证就可访问的 url
        private String[] permitUrl = {"/*","/authentication/auth","/goAdminLogin","/goHomePage"};

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers(staticFileUrl);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();

            // 访问url认证
            http
                    .authorizeRequests()
                    .antMatchers(permitUrl).permitAll()
                    .antMatchers("/admin/**").hasAnyRole("ADMIN")
                    .anyRequest().authenticated();

            // 配置登陆信息
            http
                    .formLogin()
                    .permitAll()
                    .and();

            // 配置退出登陆信息
            http
                    .logout()
                    .invalidateHttpSession(true)
                    .deleteCookies()
                    .and();

            http.addFilterBefore(jwtAuthenticationTokenFilter,UsernamePasswordAuthenticationFilter.class);

            http.httpBasic();
        }
    }
}


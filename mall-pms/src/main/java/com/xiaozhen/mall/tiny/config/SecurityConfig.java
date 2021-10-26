package com.xiaozhen.mall.tiny.config;

import com.xiaozhen.mall.tiny.component.JwtAuthenticationTokenFilter;
import com.xiaozhen.mall.tiny.component.RestAuthenticationEntryPoint;
import com.xiaozhen.mall.tiny.component.RestfulAccessDeniedHandler;
import com.xiaozhen.mall.tiny.dto.AdminUserDetails;
import com.xiaozhen.mall.tiny.mbg.model.UmsAdmin;
import com.xiaozhen.mall.tiny.mbg.model.UmsPermission;
import com.xiaozhen.mall.tiny.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @description: SpringSecurity的配置
 * @create time:2021/10/25
 * @Author: XiaoZhen
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired(required = false)
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired(required = false)
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private UmsAdminService adminService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf() // 由于使用的是JWT,这里不需要csrf
                .disable()
                .sessionManagement()    // 基于token,所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET,    // 允许对与网站静态资源的无授权访问
//                        "/*",
//                        "/*.html",
//                        "/favicon.ico",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js",
//                        "/swagger-resources/**",
//                        "/v2/api-docs/**")
//                .permitAll()
//                .antMatchers("/admin/login", "/admin/register")  // 对登录注册要允许匿名访问
//                .permitAll()
                .antMatchers("/**") // 测试是全部运行访问
                .permitAll()
                .anyRequest()   // 出上面外的所有请求全部需要鉴权认证
                .authenticated();
        // 禁用缓存
        http.headers().cacheControl();
        // 添加Jwt filter
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // 添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 获取登录用户信息
        return username -> {
            UmsAdmin admin = adminService.getAdminByUsername(username);
            if (admin != null) {
                List<UmsPermission> permissionList = adminService.getPermissionList(admin.getId());
                return new AdminUserDetails(admin, permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

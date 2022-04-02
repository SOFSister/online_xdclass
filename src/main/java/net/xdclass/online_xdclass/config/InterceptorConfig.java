package net.xdclass.online_xdclass.config;

import net.xdclass.online_xdclass.interceptor.CorsInterceptor;
import net.xdclass.online_xdclass.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Soft_Sister
 * @version : 1.0
 * @Project : online_xdclass
 * @Package : net.xdclass.online_xdclass.interceptor
 * @ClassName : InterceptorConfig.java
 * @createTime : 2022/3/8 11:12
 * @Email : 874280179@qq.com
 * @Description :
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 添加全局跨域拦截器配置
         */
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/**")
                .excludePathPatterns("/api/v1/pri/user/register","/api/v1/pri/user/login");

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Bean
    public CorsInterceptor corsInterceptor(){return new CorsInterceptor();}

}

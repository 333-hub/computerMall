package com.xsx.computermall.config;

import com.xsx.computermall.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns(
                "/user","/cart","/order","/manager/index");
    }

    /**
     *
     * 所有WebMvcConfigurer组件都会一起作用
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/register").setViewName("register");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/user").setViewName("user");
                registry.addViewController("/cart").setViewName("cart");
                registry.addViewController("/cart.html").setViewName("cart");
                registry.addViewController("/order").setViewName("order");
                registry.addViewController("/details.html").setViewName("details");
                registry.addViewController("/details").setViewName("details");
                registry.addViewController("/order.html").setViewName("order");
                registry.addViewController("/goods.html").setViewName("goods");
                registry.addViewController("/goods").setViewName("goods");
                registry.addViewController("/back/index").setViewName("back/index");
                registry.addViewController("/back/manager/index").setViewName("back/manager/index");
                registry.addViewController("/back/manager/admin").setViewName("back/manager/admin");
                registry.addViewController("/back/manager/goods").setViewName("back/manager/goods");
                registry.addViewController("/back/manager/type").setViewName("back/manager/type");
                registry.addViewController("/back/manager/view").setViewName("back/manager/view");
                registry.addViewController("/back/manager/welcome").setViewName("back/manager/welcome");
                registry.addViewController("/back/manager/member").setViewName("back/manager/member");
            }
        };

        return configurer;
    }
}

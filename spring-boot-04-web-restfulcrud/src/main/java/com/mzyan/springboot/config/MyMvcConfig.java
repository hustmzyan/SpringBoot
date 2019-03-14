package com.mzyan.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 使用 WebMvcConfigurerAdapter 来扩展 SpringMVC 的功能
 * WebMvcConfigurerAdapter 已不推荐使用
 */
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //作用：浏览器发送"/mzyan"请求，也来到success页面
        registry.addViewController("/mzyan").setViewName("success");
//        registry.addViewController("/").setViewName("index");
    }

//    // 所有 WebMvcConfigurer 组件都会一起起作用
//    public WebMvcConfigurer webMvcConfigurer(){
//        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/index.html").setViewName("index");
//            }
//        };
//        return webMvcConfigurer;
//    }
}

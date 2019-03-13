package com.mzyan.springboot.config;


import com.mzyan.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration：指明是一个配置类
 *
 * 在Spring传统XML文件中，使用<bean></bean>标签添加组件
 *
 * SpringBoot 中推荐使用配置类添加组件
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中：容器中这个组件的默认ID就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加组件了..。");
        return new HelloService();
    }
}

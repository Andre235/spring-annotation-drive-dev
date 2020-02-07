package com.hacker.config;

import com.hacker.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author : Jeffersonnn
 * @date : 2020/2/6
 * @description :
 */
/**
 * value:要扫描哪些包
 * excludeFilters:要排除包中的哪些类
 */
@Configuration //该配置类相当于配置文件
@ComponentScan(value = "com.hacker",excludeFilters =
    @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})) //包扫描
public class MyConfig {

    @Bean(name = "BeanName")  //在spring容器中注册person对象
    public Person person(){
        return new Person("natasha",21);
    }
}

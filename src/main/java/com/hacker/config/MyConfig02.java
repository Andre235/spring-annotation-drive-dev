package com.hacker.config;

import com.hacker.bean.Person;
import com.hacker.conditional.LinuxConditional;
import com.hacker.conditional.WindowsConditional;
import org.springframework.context.annotation.*;
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
public class MyConfig02 {

    /**
     * value:
     *      prototype 多例模式 但是在多实例模式中，什么时候调用该对象，什么时候创建该对象
     *      singleton 单例模式，默认在单例模式中，随着IOC容器启动，单例对象也会被创建并注入到容器中
     */
    @Scope(value = "prototype")
    @Bean(name = "BeanName")  //在spring容器中注册person对象
    public Person person(){
        System.out.println("创建Person对象...");
        return new Person("natasha",21);
    }

    /**
     * @Lazy 注解为懒加载注解，只针对单例模式
     * 开启懒加载注解后在IOC容器启动完成后不立即创建Bean对象，而是什么时候用，什么时候创建对象
     */
    @Lazy
    @Bean(name = "person")  //在spring容器中注册person对象
    public Person person01(){
        System.out.println("Person对象创建完成...");
        return new Person("natasha",21);
    }

    @Conditional({WindowsConditional.class})
    @Bean(name = "bill")  //在spring容器中注册person对象
    public Person person03(){
        System.out.println("bill对象创建完成...");
        return new Person("bill",62);
    }

    @Conditional({LinuxConditional.class})
    @Bean(name = "linux")  //在spring容器中注册person对象
    public Person person04(){
        System.out.println("linux对象创建完成...");
        return new Person("linux",100);
    }
}

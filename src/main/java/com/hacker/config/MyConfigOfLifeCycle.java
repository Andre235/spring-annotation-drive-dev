package com.hacker.config;

import com.hacker.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Jeffersonnn
 * @date : 2020/2/6
 * @description : bean对象的生命周期
 */
@Configuration
public class MyConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}

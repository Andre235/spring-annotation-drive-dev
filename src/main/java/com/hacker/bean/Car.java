package com.hacker.bean;

/**
 * @author : Jeffersonnn
 * @date : 2020/2/6
 * @description :
 */
public class Car {

    public Car(){
        System.out.println("创建car对象完成...");
    }

    public void init(){
        System.out.println("car init success...");
    }

    public void destroy(){
        System.out.println("car destroy success...");
    }
}

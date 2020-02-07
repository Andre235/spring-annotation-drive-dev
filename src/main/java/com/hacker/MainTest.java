package com.hacker;

import com.hacker.bean.Person;
import com.hacker.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Jeffersonnn
 * @date : 2020/2/6
 * @description :
 */
public class MainTest {

    public static void main(String[] args) {

        //通过xml配置文件获取bean对象
        //构造方法中传入配置文件的名称
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person)context.getBean("person");
        System.out.println(person);

        //通过@Bean注解获取bean对象
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(MyConfig.class);
        Person bean = context1.getBean(Person.class);
        System.out.println(bean);
        //获取bean对象在spring容器中注册的名称
        String[] beanNamesForType = context1.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}

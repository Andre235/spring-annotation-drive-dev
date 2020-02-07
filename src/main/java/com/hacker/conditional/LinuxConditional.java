package com.hacker.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


/**
 * @author : Jeffersonnn
 * @date : 2020/2/6
 * @description :
 */
public class LinuxConditional implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取环境配置信息
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        return property.contains("Linux");
    }
}

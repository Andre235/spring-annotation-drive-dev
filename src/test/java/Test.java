import com.hacker.bean.Person;
import com.hacker.config.MyConfig;
import com.hacker.config.MyConfig02;
import com.hacker.config.MyConfigOfLifeCycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author : Jeffersonnn
 * @date : 2020/2/6
 * @description :
 */
public class Test {

    @org.junit.Test
    public void testBeanLifeCycle(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfLifeCycle.class);
        System.out.println("IOC容器启动完成...");

        //关闭IOC容器
        context.close();
    }

    /**
     * 测试@Conditional注解(动态注入Bean对象)
     */
    @org.junit.Test
    public void testConditional(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig02.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("当前系统环境为"+property);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }

    /**
     * 测试单例模式、多例模式
     */
    @org.junit.Test
    public void testScope(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig02.class);
        //多例模式
        Object beanName = context.getBean("BeanName");
        Object beanName01 = context.getBean("BeanName");
            System.out.println(beanName == beanName01);
    }

    /**
     * 测试包扫描注解
     */
    @org.junit.Test
    public void componentScan(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //获取容器中所有的bean名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String string : beanDefinitionNames) {
            System.out.println(string);
        }
    }

    /**
     * 测试包扫描注解
     */
    @org.junit.Test
    public void testLazy(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig02.class);
        System.out.println("IOC容器启动完成...");
        Object person = context.getBean("person");

    }
}

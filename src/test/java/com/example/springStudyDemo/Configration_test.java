package com.example.springStudyDemo;

import com.example.springStudyDemo.config.MyPersonBean;
import com.example.springStudyDemo.config.MyPersonBean2;
import com.example.springStudyDemo.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootTest
public class Configration_test {

    @Test
    public void test04() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyPersonBean2.class);
        System.out.println("cntext创建完成");

        String[] names = context.getBeanDefinitionNames();
        for (String name:names){
            System.out.println(name);
        }

        //工厂bean获得的是调用getObject 获得的对象
        Object getFactoryBean = context.getBean("getFactoryBean");
        //类型是ComponentColor
        System.out.println(getFactoryBean.getClass());

        //bean名称前加&前缀，表示获取其工厂bean
        Object getFactoryBean2 = context.getBean("&getFactoryBean");
        //得到工厂bean的类型MyFactoryBean
        System.out.println(getFactoryBean2.getClass());

    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyPersonBean2.class);
        System.out.println("cntext创建完成");

        //在test03的vm options 中可以添加-Dos.name=linux 这个配置，可以将运行环境改为linux
        //动态获取环境变量的配置
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);//Windows 7

        // String[] names = context.getBeanNamesForType(Person.class);
        // for (String name:names){
        //     System.out.println(name);
        // }

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);


    }

    @Test
    public void test01() {
        //注意传入的是配置类的class类型
        ApplicationContext context = new AnnotationConfigApplicationContext(MyPersonBean.class);
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
//		String[] beanNamesForTypes = context.getBeanNamesForType(Person.class);
//		for (String name:beanNamesForTypes){
//			System.out.println(name);
//		}

//如果给MyPersonBean这个配置类加上@ComponentScan(value="com.example.springStudyDemo")
//      则context可以获取指定包下的所有的bean，注：启动类的上面的注解是包含ComponentScan的
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);//打印出所有的bean
        }
//ComponentScan可以指定需要排除的扫描类型

    }

    @Test
    public void test02() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyPersonBean2.class);
        System.out.println("cntext创建完成");
        // Person bean = context.getBean(Person.class);
        Person bean = (Person) context.getBean("person2");
        Person bean2 = (Person) context.getBean("person2");
        System.out.println(bean == bean2);
        System.out.println(bean);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);//打印出所有的bean
        }
    }
}

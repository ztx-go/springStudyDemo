package com.example.springStudyDemo;

import com.example.springStudyDemo.AOP.MyAOP;
import com.example.springStudyDemo.AOP.MyService;
import com.example.springStudyDemo.config.MyBeanLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class IOC_test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBeanLifeCycle.class);
        System.out.println("容器创建完成");
        //关闭容器 会执行销毁方法
        context.close();
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAOP.class);
        System.out.println("容器创建完成");
        MyService myService = context.getBean(MyService.class);
        myService.doServce();

        //关闭容器 会执行销毁方法
        context.close();
    }
}

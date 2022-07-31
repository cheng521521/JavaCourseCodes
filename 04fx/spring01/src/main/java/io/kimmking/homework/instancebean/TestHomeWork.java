package io.kimmking.homework.instancebean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author cpx
 * @Description
 * @date 2022/7/31
 */
public class TestHomeWork {
    public static void main(String[] args) {
        ApplicationContext context  = new ClassPathXmlApplicationContext("classpath:/applicationContextcpx.xml");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(">>>>>" + name);
        }
    }
}

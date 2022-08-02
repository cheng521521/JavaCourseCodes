package io.kimmking.homework.aop;

import io.kimmking.homework.mybatis.IUserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @author cpx
 * @Description
 * @date 2022/7/31
 */
public class TestDemo {
    public static void main(String[] args) {
        SchoolProxy schoolProxy = new SchoolProxy(new ISchool());
        School school = (School) Proxy.newProxyInstance(schoolProxy.getClass().getClassLoader(), new Class[]{School.class},schoolProxy);
        school.start();
        System.out.println("===============");
        System.out.println("测试mybatis");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/applicationContextcpx.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        System.out.println(userDao.queryUserInfo());
    }
}

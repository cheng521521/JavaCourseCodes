package io.kimmking.homework.aop;

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
    }
}

package io.kimmking.homework.mybatis;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
    *@ClassName ProxyBeanFactory
    *@Author jackchen
    *@Date 2022/8/2 15:00
    *@Description TODO
    **/
public class ProxyBeanFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class[] classes = {IUserDao.class};
        InvocationHandler handler = (proxy, method, args) -> "你被代理了" + method.getName();
        return Proxy.newProxyInstance(classLoader, classes, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

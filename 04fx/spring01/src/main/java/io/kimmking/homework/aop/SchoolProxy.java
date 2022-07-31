package io.kimmking.homework.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cpx
 * @Description
 * @date 2022/7/31
 */
public class SchoolProxy implements InvocationHandler {
    private Object bean;

    public SchoolProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("start")) {
            System.out.println("上课铃声响了");
        } else {
            System.out.println("下课铃声响了");
        }
        return method.invoke(bean, args);
    }
}

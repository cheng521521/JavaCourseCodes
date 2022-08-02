package io.kimmking.homework.mockmybatis;

import io.kimmking.homework.mockmybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @ClassName MapperProxy
 * @Author jackchen
 * @Date 2022/8/2 17:39
 * @Description TODO
 **/
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6424540398559729838L;
    private SqlSession sqlSession;
    private final Class<T> mappperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mappperInterface) {
        this.sqlSession = sqlSession;
        this.mappperInterface = mappperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        System.out.println(mappperInterface.getName());
        return "你被代理了" + sqlSession.selectOne(method.getName(), args);
    }
}

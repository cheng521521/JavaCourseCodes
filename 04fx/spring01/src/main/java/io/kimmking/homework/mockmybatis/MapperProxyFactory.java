package io.kimmking.homework.mockmybatis;

import io.kimmking.homework.mockmybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @ClassName MapperProxyFactory
 * @Author jackchen
 * @Date 2022/8/2 17:43
 * @Description TODO
 **/
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperProxy.getClass().getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}

package io.kimmking.homework.mockmybatis.session;

import io.kimmking.homework.mockmybatis.binding.MapperRegistry;

/**
 * @ClassName DefaultSqlSession
 * @Author jackchen
 * @Date 2022/8/2 18:16
 * @Description TODO
 **/
public class DefaultSqlSession implements SqlSession{

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}

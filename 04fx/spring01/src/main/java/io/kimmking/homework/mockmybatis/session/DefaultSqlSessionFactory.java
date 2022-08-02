package io.kimmking.homework.mockmybatis.session;

import io.kimmking.homework.mockmybatis.binding.MapperRegistry;

/**
 * @ClassName DefaultSqlSessionFactory
 * @Author jackchen
 * @Date 2022/8/2 18:19
 * @Description TODO
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}

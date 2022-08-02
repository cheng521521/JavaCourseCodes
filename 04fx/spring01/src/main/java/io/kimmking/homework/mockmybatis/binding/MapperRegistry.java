package io.kimmking.homework.mockmybatis.binding;

import io.kimmking.homework.mockmybatis.MapperProxyFactory;
import io.kimmking.homework.mockmybatis.session.SqlSession;
import io.kimmking.homework.mockmybatis.utils.ClassScanner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapperRegistry
 * @Author jackchen
 * @Date 2022/8/2 18:03
 * @Description TODO
 **/
public class MapperRegistry {
    /**
     * 将mapper接口和mapper接口的代理工程联系起来
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("mapper接口对应的代理工厂没有找见");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("不能获取mapper接口的实例对象");
        }
    }

    //将mapper接口注册到knowMapper里面去
    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (knownMappers.containsKey(type)) {
                throw new RuntimeException("mapper接口已经被注册了");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public void addMappers(String packageName) throws IOException, ClassNotFoundException {
        List<Class> mapperSet = findClass(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }
    /**
     * 提供直接调用的方法
     * @param packageName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static  List<Class> findClass(String packageName) throws IOException, ClassNotFoundException {
        return findClass(packageName, new ArrayList<>());
    }

    /**
     *
     * @param packageName
     * @param clazzs
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static List<Class> findClass(String packageName, List<Class> clazzs) throws ClassNotFoundException, IOException {
        //将报名替换成目录
        String fileName = packageName.replaceAll("\\.", "/");
        //通过classloader来获取文件列表
        File file = new File(Thread.currentThread().getContextClassLoader().getResource(fileName).getFile());
        File[] files = file.listFiles();
        for (File f:files) {
            //如果是目录，这进一个寻找
            if (f.isDirectory()) {
                //截取路径最后的文件夹名
                String currentPathName = f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf(File.separator)+1);
                //进一步寻找
                findClass(packageName+"."+currentPathName, clazzs);
            } else {
                //如果是class文件
                if (f.getName().endsWith(".class")) {
                    //反射出实例
                    Class clazz = Thread.currentThread().getContextClassLoader().loadClass(packageName+"."+f.getName().replace(".class",""));
                    clazzs.add(clazz);
                }
            }
        }
        return clazzs;
    }
}

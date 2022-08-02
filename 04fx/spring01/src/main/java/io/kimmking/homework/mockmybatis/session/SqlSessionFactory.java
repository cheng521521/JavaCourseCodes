package io.kimmking.homework.mockmybatis.session;

/**
 * @ClassName SqlSessionFactory
 * @Author jackchen
 * @Date 2022/8/2 18:19
 * @Description TODO
 **/
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}

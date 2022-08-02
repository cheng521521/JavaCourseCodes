package io.kimmking.homework.mockmybatis;

/**
 * @ClassName IUserDao
 * @Author jackchen
 * @Date 2022/8/2 17:48
 * @Description TODO
 **/
public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}

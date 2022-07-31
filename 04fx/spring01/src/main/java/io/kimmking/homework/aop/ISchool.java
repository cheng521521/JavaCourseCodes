package io.kimmking.homework.aop;

/**
 * @author cpx
 * @Description
 * @date 2022/7/31
 */
public class ISchool implements School{
    @Override
    public void start() {
        System.out.println("开始上课了");
    }
}

package io.kimmking.homework.instancebean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cpx
 * @Description
 * @date 2022/7/31
 */
public class Teacher {
    private int age;
    private String name;

    public Teacher(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Teacher() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

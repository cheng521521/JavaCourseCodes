package io.kimmking.homework.instancebean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author cpx
 * @Description
 * @date 2022/7/31
 */
@Service
public class AnnotationBean {
    @Bean
    public Teacher generateTeacher() {
        return new Teacher(20,"程鹏祥");
    }
}

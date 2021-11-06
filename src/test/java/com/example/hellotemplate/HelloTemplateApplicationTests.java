package com.example.hellotemplate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class HelloTemplateApplicationTests {

    @Test
    void contextLoads() {
        List<Integer> list1 = Arrays.asList(1, 56, 78, 101, 10, 8, 7, 3, 11);
        List<Integer> list2 = Arrays.asList(1, 56, 78, 101, 12, 8, 7, 3, 11);
        /*Collections.shuffle(list1);
        System.out.println(list1);*/

        for (int i = 0; i < list1.size(); i++) {
            Integer result = list1.get(i) ^ list2.get(i);
            System.out.println(result);
        }

    }


}

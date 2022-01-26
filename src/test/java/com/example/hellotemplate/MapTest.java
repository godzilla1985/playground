package com.example.hellotemplate;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTest {


    @Test
    public void setTest(){
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("B");
        System.out.println(set);
    }


    @Test
    public void duplicateMapTest(){
        Map<String,String> map = new HashMap<>();
        map.put("A","B");
        map.putIfAbsent("A","C");
        System.out.println(map);
    }

    @Test
    public void helloTest(){
        System.out.println("Hello");
    }

}

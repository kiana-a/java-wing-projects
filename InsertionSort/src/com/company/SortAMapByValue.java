package com.company;


import java.util.*;

/**
 * Created by kiana on 3/11/18.
 */
public class SortAMapByValue {

    public static void main(String[] args) {
        Map<String , Integer> map = new HashMap<>();
        map.put("java",19);
        map.put("c#",1909090);
        map.put("sldaajwhf;ojqhfa;",0);
        map.put("CPP",45);
        //A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction.
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        List<Map.Entry<String , Integer>> list = new ArrayList<>(set);
        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        for (Map.Entry<String,Integer> entry:list){
            System.out.println(entry.getKey() + " ---> "+ entry.getValue());
        }


    }
}

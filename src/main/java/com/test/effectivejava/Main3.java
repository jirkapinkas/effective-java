package com.test.effectivejava;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        // Prefer for-each loops to traditional for loops
        List<Integer> integers = new ArrayList<>(List.of(1,2,3,4,5));
        // NEE !!!
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

        // OK ^_^
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        // OK ^_^
        integers.forEach(System.out::println);

        // Pozor na autoboxing
//        Long sum = 0L; // tohle ma byt spravne "long"
//        for (long i = 0; i < Integer.MAX_VALUE; i++) {
//            sum += i;
//        }
//        System.out.println(sum);

        // Beware the performance of string concatenation => StringBuilder
        // takhle nee!!!
        String s1 = "";
        for (int i = 0; i < 1_000; i++) {
            s1 += i;
        }

        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < 1_000; i++) {
            s2.append(i);
        }

    }

}

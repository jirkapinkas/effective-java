package com.test.effectivejava;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Static factory methods instead of constructors
        Boolean value1 = Boolean.valueOf("true"); // ANO
        Boolean value2 = new Boolean("true"); // NEE

        List<Integer> integers1 = List.of(1, 2, 3); // ANO
        List<Integer> integers2 = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(1,2,3))); // NEE

    }

}

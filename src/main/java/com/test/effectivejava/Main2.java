package com.test.effectivejava;

import com.test.effectivejava.pojo.Person;

public class Main2 {

    public static void main(String[] args) {
        // equals vs. ==,  pozor na == u Stringu nebo například Integer
        // SPATNE!!!
        System.out.println("test" == "test"); // NEPOUZIVAT, vrati true
        System.out.println(new String("test") == new String("test")); // NEPOUZIVAT, vrati false
        System.out.println(new Integer(1) == new Integer(1)); // NEPOUZIVAT, vrati false

        // SPRAVNE => pomoci equals()
        System.out.println("test".equals("test")); // vrati true
        System.out.println(new String("test").equals(new String("test"))); // vrati true
        System.out.println(1 == 1); // u primitivnich datovych typu OK, vrati true
        System.out.println(new Integer(1).equals(new Integer(1))); // vrati true

        // K cemu je ==
        // 1. Zjisteni, jestli 2 primitivni datove typy obsahuji stejnou hodnotu
        // 2. Jestli 2 reference ukazuji na stejny objekt
        String s1 = new String("test");
        String s2 = s1;
        String s3 = new String("test");
        // mame: 1 objekt, ALE 2 reference na ten objekt

        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf(10);
        System.out.println(i1 == i2); // SPATNE, true
        System.out.println(i1.equals(i2)); // SPRAVNE, true

        Integer i3 = Integer.valueOf(10_000);
        Integer i4 = Integer.valueOf(10_000);
        System.out.println(i3 == i4); // SPATNE, false
        System.out.println(i3.equals(i4)); // SPRAVNE, true

        Person p1 = Person.builder()
                .firstName("Jirka")
                .build();
        Person p2 = Person.builder()
                .firstName("Jirka")
                .build();
        System.out.println(p1.equals(p2));
    }
}

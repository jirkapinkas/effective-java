package com.test.effectivejava.streams;

// funkcionalni interface = interface s PRAVE JEDNOU ABSTRAKTNI METODOU!!!

import com.test.effectivejava.pojo.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface I1 {

}

@FunctionalInterface
interface I2 {
    void test();

    static void testStatic() {

    }

    default void testDefault() {

    }
}

interface I3 {
    /*public static final*/ String TRAINING = "Java Streams";
    /*public abstract*/ void test1();
    void test2();
}

class ComparePersonByFirstName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

public class Main_01_Lambda {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                Person.builder().firstName("Michal").lastName("Pinkas").build(),
                Person.builder().firstName("Jirka").lastName("Pinkas").build(),
                Person.builder().firstName("Alex").lastName("Zabka").build()
        );

        // 1. Trida, ktera implementuje Comparator<Person>
//        Collections.sort(people, new ComparePersonByFirstName());

        // 2. Anonymous class
//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getFirstName().compareTo(o2.getFirstName());
//            }
//        });

        // 3. Lambda ... POZOR! Funguje pouze s funkcionalnim interfacem!!!
//        Collections.sort(people, (Person o1, Person o2) -> {
//                return o1.getFirstName().compareTo(o2.getFirstName());
//            });

//        Collections.sort(people, (o1, o2) -> {
//            return o1.getFirstName().compareTo(o2.getFirstName());
//        });

//        Collections.sort(people, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));

//        Collections.sort(people, Comparator.comparing(Person::getFirstName));

        // FINALNI PODOBA!
//        people.sort(Comparator.comparing(Person::getFirstName));

        people.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));

        // Method reference
        people.forEach(System.out::println);
    }

}

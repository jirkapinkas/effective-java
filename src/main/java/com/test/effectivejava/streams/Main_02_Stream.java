package com.test.effectivejava.streams;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_02_Stream {

    public static void main(String[] args) {
        List<String> dogs = List.of("Alik", "Beta", "Lulu", "Nano", "Peso", "Azor");

        // starym zpusobem
        for (String dog : dogs) {
            if(!dog.startsWith("A")) {
                continue;
            }
            System.out.println("DOG: " + dog.toUpperCase());
        }

        // to same pomoci streamu
        dogs.stream()
                .filter(e -> e.startsWith("A"))
                .map(String::toUpperCase)
                .map(e -> "DOG: " + e)
                .forEach(System.out::println);

        System.out.println("xxxxxxxxxxxxx");

        dogs.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("xxxxxxxxxxxxx");

        Optional<String> minDog = dogs.stream()
                .min(Comparator.naturalOrder());
        System.out.println("MIN DOG: ");
        minDog.ifPresent(System.out::println);

        System.out.println("xxxxxxxxxxxxx");

        Optional<String> maxDog = dogs.stream()
                .max(Comparator.naturalOrder());
        System.out.println("MAX DOG: ");
        maxDog.ifPresent(System.out::println);

        System.out.println("xxxxxxxxxxxxx");

        List<String> finalList = dogs.stream()
                .filter(e -> e.startsWith("A"))
                .map(String::toUpperCase)
                .map(e -> "DOG: " + e)
                .collect(Collectors.toList());

        System.out.println("xxxxxxxxxxxxx");

        int sum = List.of(1, 2, 3, 5, 10, 0, 1, 2)
                .stream()
                .mapToInt(e -> e)
                .sum();

        System.out.println("xxxxxxxxxxxxx");

        Optional<BigDecimal> reduced = List.of(new BigDecimal("0.1"), new BigDecimal("0.2"))
                .stream()
                .reduce(BigDecimal::add);
        System.out.println("sum: 0.1 + 0.2 (BigDecimal):");
        reduced.ifPresent(System.out::println);

        System.out.println("xxxxxxxxxxxxx");

        // flatmap: [[a,b,c][x,y,z]] -> [a,b,c,x,y,z]
        Stream.of(List.of("a", "b", "c"), List.of("x", "y", "z"))
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

}

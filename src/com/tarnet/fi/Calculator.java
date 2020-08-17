package com.tarnet.fi;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Calculator {
    public static void main(String[] args) {
        LongBasicCalculator addition = (n1, n2) -> n1 + n2;
        LongBasicCalculator division = (n1, n2) -> n1 / n2;
        LongBasicCalculator modulus = (n1, n2) -> n1 % n2;
        LongSingleCalculator sqrt = n -> (long) Math.pow(n, 2);

//        System.out.println(addition.calculate(3, 5));
//        System.out.println(division.calculate(4, 2));

//        IntStream
//                .range(2, 10)
//                .mapToLong(i -> sqrt.calculate(i))
//                .forEach(System.out::println);

        // IntStream.range(1,11);
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        int result = 0;
//        for (int i : numbers) {
//            result += i;
//        }
//        System.out.println(result);

//        int total = IntStream.range(1, 10).reduce(0, Integer::sum);
//        System.out.println(total);

        List<String> letters = Arrays.asList("E", "r", "s", "i", "n", " ", "K", "i", "l", "i", "c");

        // BEGIN GANI
        String result = letters.stream().reduce("", String::concat);
//        System.out.println(result);
        // END GANI

//        List<String> fruits = Arrays.asList("Apple", "Orange", "Apricot", "Banana", "Strawberry", "Cherry", "Clementine", "Blueberry");

//        boolean containsZletter = false;
//        for (String f : fruits) {
//            containsZletter = f.contains("z");
//            if(containsZletter){
//                break;
//            }
//        }
//        boolean containsZLetter = fruits.stream().anyMatch(l -> l.contains("z"));
//        boolean allContainsLetterA = fruits.stream().allMatch(l -> l.contains("a"));
//        boolean noneOfContainsZLetter = fruits.stream().noneMatch(l -> l.contains("z"));
//        System.out.println("Contains Letter Z:" + containsZLetter);
//        System.out.println("All Contains Letter A:" + allContainsLetterA);
//        System.out.println("None Of Contains Letter Z:" + noneOfContainsZLetter);

//        fruits.stream().map(String::toUpperCase).forEach(System.out::println);

        List<List<String>> fruits = Arrays.asList(
                Arrays.asList("Apple", "Apricot"),
                Arrays.asList("Banana","Strawberry", "Blueberry"),
                Arrays.asList("Cherry", "Clementine"),
                Arrays.asList("Orange","Banana"),
                Arrays.asList("Strawberry"));

//        fruits.stream().map(List::size).forEach(System.out::println);
//        fruits.stream().flatMap(Collection::stream).forEach(System.out::println);
// "Apple", "Apricot", "Banana", "Blueberry", "Cherry", "Clementine","Orange","Strawberry"
    }
}
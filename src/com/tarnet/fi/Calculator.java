package com.tarnet.fi;

import java.util.*;
import java.util.stream.Collectors;

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
//        String result = letters.stream().reduce("", String::concat);
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
                Arrays.asList("Banana", "Strawberry", "Blueberry"),
                Arrays.asList("Cherry", "Clementine"),
                Arrays.asList("Orange", "Banana"),
                Arrays.asList("Strawberry"),
                null);

//        fruits.stream().map(List::size).forEach(System.out::println);
//        fruits.stream().flatMap(Collection::stream).forEach(System.out::println);
// "Apple", "Apricot", "Banana", "Blueberry", "Cherry", "Clementine","Orange","Strawberry"

//        fruits.stream().filter(Objects::nonNull).flatMap(Collection::stream).distinct().forEach(System.out::println);

//        List<String> distictFruits = fruits
//                .stream()
//                .filter(Objects::nonNull)
//                .flatMap(Collection::stream)
//                .distinct()
//                .collect(Collectors.toList());
//        Set<String> distinctF = fruits
//                .stream()
//                .filter(Objects::nonNull)
//                .flatMap(Collection::stream)
//                .collect(Collectors.toSet());
//        System.out.println(distinctF.size());

//        List<String> distinctFruit=fruits
//                .stream()
//                .filter(Objects::nonNull)
//                .flatMap(Collection::stream)
//                .distinct()
//                .collect(Collectors.toCollection(LinkedList::new));

//        Map<String,Integer> letterCount= fruits
//                .stream()
//                .filter(Objects::nonNull)
//                .flatMap(Collection::stream)
////                .distinct()
//                .collect(Collectors.toMap(Function.identity(),String::length,(item,otheritem)->item));


// Counting

//        long result = fruits.stream().collect(Collectors.counting());

// Average

//        double result = fruits.stream().filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.averagingDouble(String::length));

// Summary

//        DoubleSummaryStatistics result =fruits.stream().filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.summarizingDouble(String::length));
//
//        System.out.println("Avarage:"+result.getAverage());
//        System.out.println("Count:"+result.getCount());
//        System.out.println("Max:"+result.getMax());
//        System.out.println("Min:"+result.getMin());
//        System.out.println("Sum:"+result.getSum());

//        MAX / MIN

//        Optional<String> minValue = fruits.stream()
//                .filter(Objects::nonNull)
//                .flatMap(Collection::stream)
//                .collect(Collectors.minBy(Comparator.comparingInt(String::length)));
//
//        minValue.ifPresent(v-> System.out.println(v));
//
//        Optional<String> maxValue = fruits.stream()
//                .filter(Objects::nonNull)
//                .flatMap(Collection::stream)
//                .collect(Collectors.maxBy(Comparator.comparingInt(String::length)));
//
//        maxValue.ifPresent(System.out::println);

//        JOIN

//        String result = fruits.stream().filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.joining(",","FIRST->","<-LAST"));
//
//        System.out.println(result);


//        GROUPBY

        List<List<String>> words = Arrays.asList(
                Arrays.asList("a", "aa"),
                Arrays.asList("b", "bb", "bbb"),
                Arrays.asList("c", "cc", "ccc", "cccc"),
                Arrays.asList("d"),
                Arrays.asList("e"),
                null);


        Map<Integer, List<String>> grouped = words.stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(String::length));


        System.out.println("OK");

    }
}
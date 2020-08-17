package com.tarnet.fi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

        int total = IntStream.range(1, 10).reduce(0, Integer::sum);
        System.out.println(total);

        List<String> letters = Arrays.asList("E","r","s","i","n"," ","K","i","l","i","c");

    // BEGIN GANI

    // END GANI

        // MethodReference ::


    }
}

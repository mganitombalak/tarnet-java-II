package com.tarnet;

import com.tarnet.entity.Farmer;
import com.tarnet.interfaces.IRule;
import com.tarnet.interfaces.TarnetRule;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {


        //1. CONSUMER
        //                                          |          |        Do'not use Types for parameters
        //BiConsumer<String, String> biConsumer = (String a, String b) -> System.out.println(a + b);
        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + " " + b);
        biConsumer.accept("Hello", "World");
        Consumer<String> consumer = (a) -> System.out.println(a.length());
        consumer.accept("Gani");

        //2. FUNCTION
        BiFunction<String, String, String> biFunction = (a, b) -> a + " " + b;


        //3. PREDICATE
        BiPredicate<String, String> biPredicate = (a, b) -> a == b;
        String strVariable1 = "Gani";
        String strVariable2 = "Gani";
        System.out.println(biPredicate.test(strVariable1, strVariable2));

        //4. SUPPLIER
        Supplier<String> supplier = () -> "Hello Tarim Kredi!";
        System.out.println(supplier.get());

        List<UnaryOperator<Farmer>> rules = new ArrayList<>();
        //5. UNARY OPERATOR
        UnaryOperator<Farmer> chechForCreditEligibility = (a) -> {
            if (a.firstName.length() >= 4 && a.lastName.contains("Tom")) {
                a.IsEligibleForCredit = true;
            }
            return a;
        };
        rules.add(chechForCreditEligibility);
        rules.add(o -> {
            if (o.firstName.equals("Gani")) {
                o.creditLimit = 1000000;
            }
            return o;
        });

        Farmer f = new Farmer("Gani", "Tombalak");
        Farmer f2 = new Farmer("Ahmet", "Turak");

        rules.forEach(r -> r.apply(f));
        rules.forEach(r -> r.apply(f2));

        System.out.println(f.firstName + " is eligible :" + f.IsEligibleForCredit + " for limit " + f.creditLimit);
        System.out.println(f2.firstName + " is eligible :" + f2.IsEligibleForCredit + " for limit " + f2.creditLimit);


        TarnetRule<IRule>  tr= (r)->r.Execute();
    }
}

package com.tarnet.groupbyandpartitionby;

import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class GPB {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();

        IntStream.range(1, 1000).forEach(iterator -> {
            employeeList.add(new Employee(
                    iterator,
                    Faker.instance().name().firstName(),
                    Faker.instance().name().lastName(),
                    Faker.instance().number().randomDouble(5000, 25000, 2),
                    iterator % 5 == 0 ?
                            Department.InformationTechnologies :
                            iterator % 7 == 0 ? Department.HumanResources :
                                    iterator % 11 == 0 ? Department.Procurement :
                                            Department.Marketing));
        });
    }
}

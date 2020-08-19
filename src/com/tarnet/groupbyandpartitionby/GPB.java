package com.tarnet.groupbyandpartitionby;

import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GPB {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();

        IntStream.range(1, 1001).forEach(iterator -> {
            employeeList.add(new Employee(
                    iterator,
                    Faker.instance().name().firstName(),
                    Faker.instance().name().lastName(),
                    iterator % 5 == 0 ?
                            Title.Senior :
                            iterator % 7 == 0 ? Title.Leader :
                                    iterator % 11 == 0 ? Title.Manager :
                                            Title.Employee,
                    Faker.instance().number().randomDouble(2, 5000, 25000),
                    iterator % 5 == 0 ?
                            Department.Marketing :
                            iterator % 7 == 0 ? Department.HumanResources :
                                    iterator % 11 == 0 ? Department.Procurement :
                                            Department.InformationTechnologies));
        });


        // GROUP BY DEPARTMENT

        Map<Department, List<Employee>> employeesByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));


        System.out.println("OK");
    }
}

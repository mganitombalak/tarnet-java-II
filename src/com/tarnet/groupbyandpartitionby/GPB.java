package com.tarnet.groupbyandpartitionby;

import com.github.javafaker.Faker;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;

public class GPB {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();
        IntStream.range(1, 1001).forEach(iterator -> {
            employeeList.add(new Employee(
                    iterator,
                    Faker.instance().name().firstName(),
                    Faker.instance().name().lastName(),
                    iterator % 3 == 0 ?
                            Title.Senior :
                            iterator % 11 == 0 ? Title.Leader :
                                    iterator % 17 == 0 ? Title.Manager :
                                            Title.Employee,
                    Faker.instance().number().randomDouble(2, 5000, 25000),
                    iterator % 5 == 0 ?
                            Department.Marketing :
                            iterator % 7 == 0 ? Department.HumanResources :
                                    iterator % 11 == 0 ? Department.Procurement :
                                            Department.InformationTechnologies));
        });


        // GROUP BY DEPARTMENT

//        Map<Department, List<Employee>> employeesByDepartment = employeeList.stream().collect(groupingBy(Employee::getDepartment));

        // GROUP BY DEPARTMENT THEN BY TITLE / MULTIPLE FIELD GROUPING

//        Map<Department,Map<Title,List<Employee>>> employeesByDeparmentThenByTitle = employeeList.stream().collect(groupingBy(Employee::getDepartment,groupingBy(Employee::getTitle)));


        // GROUP BY DEPARTMENT THEN BY TITLE / AVERAGE SALARY

//        Map<Department,Map<Title,Double>> avaregeSalaryByDepartmentThenByTitle = employeeList
//                .stream()
//                .collect(groupingBy(Employee::getDepartment,groupingBy(Employee::getTitle,averagingDouble(Employee::getSalary))));






        System.out.println("OK");
    }
}

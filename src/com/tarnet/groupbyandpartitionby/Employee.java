package com.tarnet.groupbyandpartitionby;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Title title;
    private double salary;
    private Department department;
}

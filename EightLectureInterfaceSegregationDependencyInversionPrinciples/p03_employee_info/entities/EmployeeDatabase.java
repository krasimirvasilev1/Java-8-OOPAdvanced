package EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDatabase implements Database {

    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees,
                new Employee("Pesho", 20),
                new Employee("Gosho", 40),
                new Employee("Ani", 1),
                new Employee("Ani",2000));

        return employees;
    }
}

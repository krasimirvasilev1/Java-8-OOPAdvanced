package EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities.Employee;

import java.util.List;

public interface InfoProvider {

    List<Employee> getEmployeesByName();

    List<Employee> getEmployeesBySalary();
}

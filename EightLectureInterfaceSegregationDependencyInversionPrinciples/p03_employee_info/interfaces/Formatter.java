package EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities.Employee;

public interface Formatter {

    String format(Iterable<Employee> employees);
}

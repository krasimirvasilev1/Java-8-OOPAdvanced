package EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces.Database;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces.InfoProvider;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider{

    private Database database;

    public EmployeeInfoProvider(Database database) {
        this.database = database;
    }

    public List<Employee> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}

package EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info;

import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities.ConsoleClient;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities.ConsoleFormatter;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities.EmployeeDatabase;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.entities.EmployeeInfoProvider;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces.Database;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces.Formatter;
import EightLectureInterfaceSegregationDependencyInversionPrinciples.p03_employee_info.interfaces.InfoProvider;

public class Main {

    public static void main(String[] args) {
        Database employeeDatabase = new EmployeeDatabase();
        InfoProvider employeeInfo = new EmployeeInfoProvider(employeeDatabase);
        Formatter formatter = new ConsoleFormatter();

        ConsoleClient consoleClient = new ConsoleClient(formatter,employeeInfo);

        String output = consoleClient.getFormatter().format(consoleClient.getInfoProvider().getEmployeesByName());
        System.out.println(output);
    }
}

package SeventhLectureOpenClosed.P04_DetailPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DetailsPrinter {

    private Iterable<Employee> employees;

    public DetailsPrinter(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public void printDetails() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        String [] values = {"krasi","kriso","vladi","valko"};
        Employee manager = new Manager("krasi",Arrays.asList(values));

        Employee ordinalEmployee = new Employee("niki");

        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees,manager,ordinalEmployee);
        DetailsPrinter detailsPrinter = new DetailsPrinter(employees);
        detailsPrinter.printDetails();
    }
}

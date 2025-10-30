package employeeStream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1L, "Alice Nguyen", "Engineering", 68000.0, 2021),
                new Employee(2L, "Ben Tran", "Engineering", 112500.0, 2019),
                new Employee(3L, "Carla Pham", "Design", 82500.0, 2020),
                new Employee(4L, "Diego Le", "Finance", 73000.0, 2022),
                new Employee(5L, "Emma Vo", "Finance", 92000.0, 2018)
        );

        Map<String, Employee> highestPaidInDepartmentMap = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().max(Comparator.comparingDouble(Employee::getSalary)).get()
                        ));

        for(Map.Entry<String, Employee> entry : highestPaidInDepartmentMap.entrySet()) {
            System.out.print(entry.getKey() + "-");
            System.out.print(entry.getValue().getName() + " . Salary: " + entry.getValue().getSalary());
            System.out.println();
        }

        System.out.println();
        long countOfEmployeesAfter2020 = employees.stream().filter(e -> e.getJoiningYear() > 2020).count();
        System.out.println("Count: " +countOfEmployeesAfter2020);

        Map<String, List<String>> departmentEmployeesMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(e -> e.getName().split(" ")[0], Collectors.toList())
                ));
        System.out.println();
        for(Map.Entry<String, List<String>> entry : departmentEmployeesMap.entrySet()) {
            System.out.print(entry.getKey() + "-");
            for(String name : entry.getValue()) {
                System.out.print(name + ", ");
            }
            System.out.println();
        }
    }
}

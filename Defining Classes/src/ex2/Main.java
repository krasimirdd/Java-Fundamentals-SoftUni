package ex2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer lines = Integer.valueOf(scanner.nextLine());
        List<String> departmentNames = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        Set<Employee> employees = new HashSet<>();

        while (lines-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Employee employee = null;

            switch (data.length) {
                case 4:
                    employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3]);
                    break;
                case 5:
                    if (data[4].contains("@")) {
                        employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4]);
                    } else {
                        employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], Integer.parseInt(data[4]));
                    }
                    break;
                case 6:
                    employee = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4], Integer.parseInt(data[5]));
            }
            employees.add(employee);

            if (!departmentNames.contains(data[3])) {
                departments.add(new Department(data[3], new ArrayList<>()));
                departmentNames.add(data[3]);
            }
            for (Employee empl : employees) {
                for (Department dep : departments) {

                    if (empl.getDepartment().equals(dep.getName())) {
                        if (!dep.getEmployees().contains(empl))
                            dep.getEmployees().add(empl);
                    }
                }
            }

        }
        System.out.println();

        Department departmentWithHigestSalary = null;
        double maxSalary = Double.MIN_VALUE;

        for (Department department : departments) {
            double salarySum = 0;

            for (Employee employee : department.getEmployees()) {
                salarySum += employee.getSalary();
            }

            if (salarySum > maxSalary) {
                maxSalary = salarySum;
                departmentWithHigestSalary = new Department(department.getName(), department.getEmployees());
            }
        }
        System.out.println("Highest Average Salary: " + departmentWithHigestSalary.getName());
        departmentWithHigestSalary.getEmployees()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEachOrdered(e -> System.out.println(e.toString()));

    }
}

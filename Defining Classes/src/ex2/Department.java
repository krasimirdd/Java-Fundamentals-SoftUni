package ex2;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;
    private String name;

    private Department() {
        employees = new ArrayList<>();
    }

    public Department(String name, List<Employee> employees) {
        this();
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}

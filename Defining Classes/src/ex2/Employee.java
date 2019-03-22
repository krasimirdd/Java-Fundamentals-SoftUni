package ex2;

class Employee {
    private final static String DEFAULT_EMAIL_VALUE = "n/a";

    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email;
    private Integer age;

    private Employee() {
        this.email = DEFAULT_EMAIL_VALUE;
        this.age = -1;
    }

    public Employee(String name, Double salary, String position, String department) {
        this();
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
    }

    public Employee(String name, Double salary, String position, String department, Integer age) {
        this(name, salary, position, department);
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department, String email, Integer age) {
        this(name, salary, position, department, email);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}

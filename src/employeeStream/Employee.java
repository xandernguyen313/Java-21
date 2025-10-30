package employeeStream;

public class Employee {
    private Long id;
    private String name;
    private String department;
    private double salary;
    private int joiningYear;

    public Employee(Long id, String name, String department, double salary, int joiningYear) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joiningYear = joiningYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getJoiningYear() {
        return joiningYear;
    }

    public void setJoiningYear(int joiningYear) {
        this.joiningYear = joiningYear;
    }
}

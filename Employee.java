import java.util.Objects;

public class Employee {
    int id;
    String name;
    int age;
    int salary;
    String dept;

    public Employee(int id, String name, int age, int salary, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
//        return id == employee.id && salary == employee.salary && Objects.equals(Name, employee.Name) && Objects.equals(dept, employee.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}

package hr.jpa.entity;

import jakarta.persistence.*;

public class EmployeeResponse   {

    //  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_seq")
//  @SequenceGenerator(name = "department_gen", sequenceName = "department_seq", initialValue = 100)
    //@TableGenerator(name = "department_gem",table = "department_seq" , allocationSize = 1, initialValue = 20)

    private int id;
    private String name;
    private double salary;

    private Department department;
    private User user;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

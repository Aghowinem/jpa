package hr.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Employee {

    @Id
    @Column(name = "id")
//  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_seq")
//  @SequenceGenerator(name = "department_gen", sequenceName = "department_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "department_gen")
    @TableGenerator(name = "department_gem",table = "department_seq" , allocationSize = 1, initialValue = 20)
    private int id;
    @Column(name = "name")
    private String name;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @JsonIgnore
    private Department department;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

package hr.jpa.entity;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Employee {


    //  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_seq")
//  @SequenceGenerator(name = "department_gen", sequenceName = "department_seq", initialValue = 100)
    //@TableGenerator(name = "department_gem",table = "department_seq" , allocationSize = 1, initialValue = 20)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "name")
    private String name;
    private double salary;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User user;

    @Version
    private int version;

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
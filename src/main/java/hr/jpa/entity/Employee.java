package hr.jpa.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "sakila")
public class Employee {


    //  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_seq")
//  @SequenceGenerator(name = "department_gen", sequenceName = "department_seq", initialValue = 100)
    //@TableGenerator(name = "department_gem",table = "department_seq" , allocationSize = 1, initialValue = 20)
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;



    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private Date lastUpdate;
    private double salary;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne()
    @JoinColumn(name = "id")
    private User user;

    public Employee() {
        super();
    }
    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public User getUser() {
        return user;
    }
}
package hr.jpa.entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Entity
@Table(name = "hr_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

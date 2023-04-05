package hr.jpa.entity;

import jakarta.persistence.*;
import org.apache.catalina.Role;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sec_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String password;
//
//	@OneToOne(mappedBy = "user" , fetch = FetchType.LAZY)
//	private Employee employee;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sec_user_roles"
            , joinColumns = @JoinColumn(name= "user_id")
            , inverseJoinColumns = @JoinColumn (name = "role_id"))
    private Set<Roles> roles = new HashSet<Roles>();


    public void addRole (Roles role) {
        roles.add(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

}
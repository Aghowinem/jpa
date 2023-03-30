package hr.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sec_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


}

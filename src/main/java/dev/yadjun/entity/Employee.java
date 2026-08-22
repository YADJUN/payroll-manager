package dev.yadjun.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeAssignment> assignments;

    public Employee() {
    }

}

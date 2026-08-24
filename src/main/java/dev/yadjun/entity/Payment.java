package dev.yadjun.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_payroll_id", nullable = false)
    private DepartmentPayroll departmentPayroll;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(nullable = false)
    private Long amount;

    private LocalDate date;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User performedBy;

    @OneToOne
    @JoinColumn(name = "cash_operation_id",nullable = false)
    private CashOperation cashOperation;
}

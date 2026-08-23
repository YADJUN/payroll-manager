package dev.yadjun.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "department_payroll", uniqueConstraints = @UniqueConstraint(columnNames = {"department_id", "period_id"}))
public class DepartmentPayroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long totalAmount;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    @ManyToOne
    @JoinColumn(name = "period_id", nullable = false)
    private SalaryPeriod period;
}

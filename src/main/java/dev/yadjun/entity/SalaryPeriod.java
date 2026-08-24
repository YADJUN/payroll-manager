package dev.yadjun.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "salary_period", uniqueConstraints = @UniqueConstraint(columnNames =
        {"month","year"}))
public class SalaryPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Month month;

}

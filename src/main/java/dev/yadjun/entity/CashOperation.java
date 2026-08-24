package dev.yadjun.entity;

import dev.yadjun.enums.CashOperationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cash_operation")
@Getter
@Setter
@NoArgsConstructor
public class CashOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @Column(nullable = false)
    private long amount;
    @Enumerated(EnumType.STRING)
    private CashOperationType type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performed_by_id",nullable = false)
    private User performedBy;
    private String comment;

}

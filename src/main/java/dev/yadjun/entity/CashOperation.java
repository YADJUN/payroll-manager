package dev.yadjun.entity;

import dev.yadjun.enums.CashOperationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class CashOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Column(nullable = false)
    private long amount;

    @Enumerated(EnumType.STRING)
    private CashOperationType type;

    @ManyToOne
    @JoinColumn(name = "performed_by_id", nullable = false)
    private User performedBy;

    private String comment;

}

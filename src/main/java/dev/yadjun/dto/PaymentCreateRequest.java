package dev.yadjun.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PaymentCreateRequest {
    @NotNull
    private Long departmentPayrollId;
    private Long employeeId;
    @NotNull
    @Positive
    private Long amount;
    private String comment;
}

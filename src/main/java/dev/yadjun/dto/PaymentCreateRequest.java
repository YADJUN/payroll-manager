package dev.yadjun.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentCreateRequest {
    @NotNull
    private Long departmentPayrollId;
    private Long employeeId;
    @NotNull
    @Positive
    private Long amount;
    private String comment;
}

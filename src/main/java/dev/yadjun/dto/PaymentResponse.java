package dev.yadjun.dto;

import java.time.LocalDate;

public record PaymentResponse(
        Long id,
        Long departmentPayrollId,
        Long employeeId,
        Long amount,
        LocalDate date,
        String comment,
        Long cashOperationId
) {
}

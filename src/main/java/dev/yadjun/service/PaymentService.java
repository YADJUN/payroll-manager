package dev.yadjun.service;

import dev.yadjun.dto.PaymentCreateRequest;
import dev.yadjun.dto.PaymentResponse;
import dev.yadjun.entity.CashOperation;
import dev.yadjun.entity.DepartmentPayroll;
import dev.yadjun.entity.Employee;
import dev.yadjun.entity.Payment;
import dev.yadjun.enums.CashOperationType;
import dev.yadjun.repository.CashOperationRepository;
import dev.yadjun.repository.DepartmentPayrollRepository;
import dev.yadjun.repository.EmployeeRepository;
import dev.yadjun.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentPayrollRepository departmentPayrollRepository;
    private final CashOperationRepository cashOperationRepository;
    private final CurrentUserService currentUserService;

    @Transactional
    public PaymentResponse createPayment(PaymentCreateRequest request) {
        LocalDate date = LocalDate.now();
        DepartmentPayroll departmentPayroll = departmentPayrollRepository.findById(request.getDepartmentPayrollId()).orElseThrow();
        Payment payment = new Payment();
        payment.setDepartmentPayroll(departmentPayroll);
        payment.setAmount(request.getAmount());
        payment.setComment(request.getComment());
        payment.setDate(date);
        Employee employee = null;
        if (request.getEmployeeId() != null) {
            employee = employeeRepository.findById(request.getEmployeeId()).orElseThrow();
        }
        payment.setEmployee(employee);

        CashOperation cashOperation = new CashOperation();
        cashOperation.setAmount(request.getAmount());
        cashOperation.setComment(request.getComment());
        cashOperation.setDate(date);
        cashOperation.setType(CashOperationType.EXPENSE);
        cashOperation.setPerformedBy(currentUserService.getCurrentUser());

        cashOperation = cashOperationRepository.save(cashOperation);

        payment.setCashOperation(cashOperation);
        paymentRepository.save(payment);
        return new PaymentResponse(
                payment.getId(),
                payment.getDepartmentPayroll().getId(),
                payment.getEmployee() != null
                        ? payment.getEmployee().getId()
                        : null,
                payment.getAmount(),
                payment.getDate(),
                payment.getComment(),
                payment.getCashOperation().getId()
        );
    }
}

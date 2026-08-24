package dev.yadjun.service;

import dev.yadjun.entity.Payment;
import dev.yadjun.repository.DepartmentPayrollRepository;
import dev.yadjun.repository.EmployeeRepository;
import dev.yadjun.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentPayrollRepository departmentPayrollRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          EmployeeRepository employeeRepository,
                          DepartmentPayrollRepository departmentPayrollRepository
    ) {
        this.paymentRepository = paymentRepository;
        this.employeeRepository = employeeRepository;
        this.departmentPayrollRepository = departmentPayrollRepository;
    }
    @Transactional
    public Payment createPAyment (Payment payment) {
        return paymentRepository.save(payment);
    }
}

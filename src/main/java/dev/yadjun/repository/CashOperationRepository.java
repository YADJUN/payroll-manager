package dev.yadjun.repository;

import dev.yadjun.entity.CashOperation;
import dev.yadjun.entity.EmployeeAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashOperationRepository extends JpaRepository<CashOperation, Long> {
}

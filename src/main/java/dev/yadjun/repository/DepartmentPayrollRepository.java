package dev.yadjun.repository;

import dev.yadjun.entity.EmployeeAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentPayrollRepository extends JpaRepository<EmployeeAssignment, Long> {
}

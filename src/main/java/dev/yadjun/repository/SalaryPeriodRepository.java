package dev.yadjun.repository;

import dev.yadjun.entity.EmployeeAssignment;
import dev.yadjun.entity.SalaryPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryPeriodRepository extends JpaRepository<SalaryPeriod, Long> {
}

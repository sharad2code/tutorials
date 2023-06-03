package com.sharad2code.restapi.repository;

import com.sharad2code.restapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface provides repository operations.
 *
 * @author SharVish
 * @since 0.1.0
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

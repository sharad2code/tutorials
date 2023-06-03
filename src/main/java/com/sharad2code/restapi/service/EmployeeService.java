package com.sharad2code.restapi.service;

import com.sharad2code.restapi.dto.EmployeeDto;

import java.util.List;

/**
 * This interfaces deals with employee related operations
 *
 * @author SharVish
 * @since 0.1.0
 */
public interface EmployeeService {
    void createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long employeeId);

    boolean updateEmployee(Long empId, EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);
}

package com.sharad2code.restapi.service;

import com.sharad2code.restapi.converter.EmployeeConverter;
import com.sharad2code.restapi.dto.EmployeeDto;
import com.sharad2code.restapi.entity.Employee;
import com.sharad2code.restapi.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is implementation class of {@link EmployeeService} which provide implementation to defined methods.
 *
 * @author SharVish
 * @since 0.1.0
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeConverter employeeConverter;

    /**
     * This method creates employee in Employee database
     *
     * @param employeeDto the request dto.
     */
    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(employeeConverter.toEmployee(employeeDto));
    }

    /**
     * This method provides all employee list in form of {@link EmployeeDto}
     *
     * @return List<EmployeeDto> the List of dto converted from Employee list.
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeConverter.toListOfEmployeeDto(employeeRepository.findAll());
    }

    /**
     * This method gets data of employees based on employee id and convert it into {@link EmployeeDto}
     *
     * @param employeeId id of employee
     * @return EmployeeDto the dto converted from Employee.
     */
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        return employeeOptional.map(employee -> employeeConverter.toEmployeeDto(employee)).orElse(null);
    }

    /**
     * This method updates employee details based on request dto
     *
     * @param employeeDto the request parameters
     * @return boolean true if update operation successful.
     */
    @Override
    public boolean updateEmployee(Long empId, EmployeeDto employeeDto) {//Brk: Check best way to update employee
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setEmpName(employeeDto.getEmpName());
            employee.setEmpAddress(employeeDto.getEmpAddress());
            employee.setAge(Long.valueOf(employeeDto.getAge()));
            employee.setSalary(Double.valueOf(employeeDto.getSalary()));

            employeeRepository.save(employee);
        } else {
            return false;
        }
        return true;
    }

    /**
     * This method deletes employee based on provided employee id
     *
     * @param employeeId id of employee.
     */
    @Override
    public void deleteEmployee(Long employeeId) {//Brk: Need to check if employee is not present
        employeeRepository.deleteById(employeeId);
    }
}

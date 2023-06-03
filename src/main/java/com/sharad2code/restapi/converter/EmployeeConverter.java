package com.sharad2code.restapi.converter;

import com.sharad2code.restapi.dto.EmployeeDto;
import com.sharad2code.restapi.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * This interface converts employee entity to employee dto,
 * employee dto to employee entity and List<Employee> to
 * List<EmployeeDto>
 *
 * @author SharVish
 * @since 0.1.0
 */
@Mapper(componentModel = "spring")
public interface EmployeeConverter {
    Employee toEmployee(EmployeeDto employeeDto);

    Employee toEmployee(Employee employee);

    EmployeeDto toEmployeeDto(Employee employee);

    List<EmployeeDto> toListOfEmployeeDto(List<Employee> employeeList);
}

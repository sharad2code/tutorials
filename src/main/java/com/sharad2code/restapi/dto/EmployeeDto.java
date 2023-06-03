package com.sharad2code.restapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * This is dto class consists request parameters for employee
 *
 * @author SharVish
 * @since 0.1.0
 */
@Getter
@Setter
@Accessors(chain = true)
public class EmployeeDto {

    private Long empId;
    private String empName;
    private String empAddress;
    private String age;
    private String salary;

}

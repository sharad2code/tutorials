package com.sharad2code.restapi.resource;

import com.sharad2code.restapi.dto.EmployeeDto;
import com.sharad2code.restapi.entity.Employee;
import com.sharad2code.restapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This Rest controller deals with Employee metadata.
 *
 * @author SharVish
 * @since 0.1.0
 */
@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeResource {

    private EmployeeService employeeService;

    /**
     * This endpoint provides list of all employees present in company
     *
     * @return ResponseEntity list present in company if available.
     */
    @GetMapping(value = "/")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        if (employees != null) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * This endpoint provides employee details based on employee id.
     *
     * @param empId id of employee
     * @return ResponseEntity with employee details if present.
     */
    @GetMapping(value = "/{empId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable String empId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(Long.valueOf(empId));
        if (employeeDto != null) {
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);//Brk: Need to set proper response
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * This endpoint creates employee based on details provided in request body.
     *
     * @param employeeDto details passed in request body
     * @return ResponseEntity with status.
     */
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * This endpoint update the employee details based on employee id and request body details.
     *
     * @param empId       id of employee
     * @param employeeDto details needs to update
     * @return ResponseEntity status code.
     */
    @PutMapping("{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Long empId,
                                                   @RequestBody EmployeeDto employeeDto) {
        boolean isUpdated = employeeService.updateEmployee(empId, employeeDto);
        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * This endpoint deletes employee based on provided employee id
     *
     * @param empId id of employee
     * @return ResponseEntity status code.
     */
    @DeleteMapping("{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Long empId) {
        employeeService.deleteEmployee(empId);
        return new ResponseEntity<>("Employee is successfully deleted!", HttpStatus.NO_CONTENT);
    }

}

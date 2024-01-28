package com.mohinur.ems.controllers;

import com.mohinur.ems.dto.EmployeeDto;
import com.mohinur.ems.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin("*")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("empId") Long empId) {
        EmployeeDto employeeDto =  employeeService.getEmployeeById(empId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/show")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("empId") Long empId,
                                                      @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(empId, employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Long empId) {
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}

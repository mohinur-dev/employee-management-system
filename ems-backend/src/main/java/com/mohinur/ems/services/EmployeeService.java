package com.mohinur.ems.services;

import com.mohinur.ems.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long empId, EmployeeDto employeeDto);

    void deleteEmployee(Long empId);
}

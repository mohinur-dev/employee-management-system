package com.mohinur.ems.services.Impl;

import com.mohinur.ems.dto.EmployeeDto;
import com.mohinur.ems.entitys.Employee;
import com.mohinur.ems.exceptions.ResourceNotFoundException;
import com.mohinur.ems.mappers.EmployeeMapper;
import com.mohinur.ems.repositorys.EmployeeRepository;
import com.mohinur.ems.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with this id not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

//    public List<EmployeeDto> getAllEmployees() {
//        List<Employee> allEmployees = employeeRepository.findAll();
//        return allEmployees.stream().map((employees)-> EmployeeMapper.mapToEmployeeDto(employees))
//                .collect(Collectors.toList());
//    }

    @Override
    public EmployeeDto updateEmployee(Long empId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee not found with this id" + empId)
        );

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee not found")
        );
        employeeRepository.deleteById(empId);
    }
}

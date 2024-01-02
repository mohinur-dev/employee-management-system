package com.mohinur.ems.repositorys;

import com.mohinur.ems.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

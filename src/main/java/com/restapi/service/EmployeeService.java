package com.restapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.Employee;

@Repository
public interface EmployeeService extends JpaRepository<Employee, Long> {
}

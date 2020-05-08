package com.ed.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ed.model.Employee;

@Repository
public interface EmployeeService extends JpaRepository<Employee, Long> {
}

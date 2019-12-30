package com.vsoft.chitti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsoft.chitti.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

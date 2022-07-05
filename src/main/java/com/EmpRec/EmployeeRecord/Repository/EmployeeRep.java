package com.EmpRec.EmployeeRecord.Repository;

import com.EmpRec.EmployeeRecord.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface EmployeeRep extends JpaRepository<Employee, Integer> { }

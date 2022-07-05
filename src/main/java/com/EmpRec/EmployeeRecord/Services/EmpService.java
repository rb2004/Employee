package com.EmpRec.EmployeeRecord.Services;

import com.EmpRec.EmployeeRecord.Entity.Employee;

import java.util.List;

public interface EmpService {

    List<Employee> getAllEmployee();

    List<Employee> addEmployee(Employee emp);

    List<Employee> ChangeEmp(Employee emp);

    Employee getEmpById(Integer id);

    List<Employee> delEmp(Integer id);
}

package com.EmpRec.EmployeeRecord.Controller;

import com.EmpRec.EmployeeRecord.Entity.Employee;
import com.EmpRec.EmployeeRecord.Services.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.logging.Logger;

@RestController
public class EmployeeController {
    @Autowired
    private EmpService empSrvs;

    Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping("/")
    public String HomePage() {
        log.info("EmployeeController Home Page");
        return "Home Page";
    }

    @GetMapping("emp")
    public List<Employee> getEmployeeList() {
        List<Employee> emp = this.empSrvs.getAllEmployee();
        log.info(String.valueOf(emp));
        return emp;
    }

    @PutMapping("emp")
    public List<Employee> ChangeEmployee(@RequestBody Employee emp) {

        return this.empSrvs.ChangeEmp(emp);
    }

    @GetMapping("emp/{empId}")
    public ResponseEntity<? extends Object> getEmpById(@PathVariable Integer empId) {
        try {
            return new ResponseEntity<Employee>(empSrvs.getEmpById(empId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Employee with given Id  {} not found",empId);
            return new ResponseEntity<String>("Employee Not Found", HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("emp/{empId}")
    public List<Employee> delEmp(@PathVariable Integer empId) {

        return this.empSrvs.delEmp(empId);
    }

    @PostMapping("emp")
    public List<Employee> addEmployee(@RequestBody Employee emp) {

        return this.empSrvs.addEmployee(emp);
    }


}

package com.EmpRec.EmployeeRecord.Controller;

import com.EmpRec.EmployeeRecord.Entity.Employee;
import com.EmpRec.EmployeeRecord.Services.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
   private EmpService empSrvs;

    Logger log= LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping("/")
    public String HomePage(){
      log.info("EmployeeController Home Page");
        return "Home Page";
    }
    @GetMapping("emp")
    public List<Employee> getEmployeeList(){
       List<Employee> emp=this.empSrvs.getAllEmployee();
       log.info(String.valueOf(emp));
        return emp;
    }

    @PutMapping("emp")
    public List<Employee> ChangeEmployee(@RequestBody Employee emp){

        return this.empSrvs.ChangeEmp(emp);
    }

    @GetMapping("emp/{empId}")
    public Employee getEmpById(@PathVariable Integer empId){
        return this.empSrvs.getEmpById(empId);
    }
    @DeleteMapping("emp/{empId}")
    public List<Employee> delEmp(@PathVariable Integer empId){

        return this.empSrvs.delEmp(empId);
    }

    @PostMapping("emp")
    public List<Employee> addEmployee(@RequestBody Employee emp){

        return this.empSrvs.addEmployee(emp);
    }


}

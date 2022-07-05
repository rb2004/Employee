package com.EmpRec.EmployeeRecord.Services;

import com.EmpRec.EmployeeRecord.Entity.Employee;
import com.EmpRec.EmployeeRecord.Repository.EmployeeRep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpServiceImp implements EmpService {

    @Autowired
    EmployeeRep repo;
    @Override
    public List<Employee> getAllEmployee() {
        try{
        return repo.findAll() ;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Employee> addEmployee(Employee emp) {
        repo.save(emp);
        return repo.findAll();
    }

    @Override
    public List<Employee> ChangeEmp(Employee emp) {
        List<Employee> abc=repo.findAll();
     //abc.stream().filter(a->a.getId()== emp.getId()).map(a->emp).collect(Collectors.toList());

        abc.stream().map(a-> {
            if (a.getId() == emp.getId()) {
                a.setName(emp.getName());
                a.setDept(emp.getDept());
                a.setSalary(emp.getSalary());

            }
            return a;
        } ).collect(Collectors.toList());

//        Employee ec=repo.findById(emp.getId()).orElse(null);
//        ec.setName(emp.getName());
//        ec.setDept(emp.getDept());
//        ec.setSalary(emp.getSalary());
//        repo.save(ec);
        return repo.findAll();
    }

    @Override
    public Employee getEmpById(Integer id) {
        try {
            return repo.findById(id).orElse(null);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("gughfhhjgchgjgvhj"+e);
        }
        return null;
    }

    @Override
    public List<Employee> delEmp(Integer id) {
        repo.deleteById(id);
        return repo.findAll();
    }
}

package ml.penkisimtai.restJersey.controller;

import ml.penkisimtai.restJersey.model.Employee;
import ml.penkisimtai.restJersey.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getAllCustomers() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/hello")
    public String helloForTesting(){
        return "Hello from Spring";
    }
}

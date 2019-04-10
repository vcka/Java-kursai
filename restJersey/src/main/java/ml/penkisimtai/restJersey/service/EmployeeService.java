package ml.penkisimtai.restJersey.service;

import ml.penkisimtai.restJersey.model.Employee;
import ml.penkisimtai.restJersey.model.Office;
import ml.penkisimtai.restJersey.repository.EmployeeRepository;
import ml.penkisimtai.restJersey.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OfficeRepository officeRepository;

    private final List<Employee> employees = new ArrayList<>();
    private final List<Office> offices = new ArrayList<>();

    @PostConstruct
    public void init() {
        Office office = new Office("Vilnius");
        officeRepository.save(office);

        Employee employee = new Employee("Jorka", "Morka", "+37065656565");
        Employee employee1 = new Employee("Gazas", "Dugnas", "+37065656565");
        Employee employee2 = new Employee("Obuolys", "Kriausinis", "+37065656565");
        employee.addOffice(office);
        employee1.addOffice(office);
        employee2.addOffice(office);
        employee1.setReportsTo(employee);
        employee2.setReportsTo(employee1);
        employeeRepository.save(employee);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


}

package ml.penkisimtai.restJersey.service;

import ml.penkisimtai.restJersey.model.Employee;
import ml.penkisimtai.restJersey.model.Office;
import ml.penkisimtai.restJersey.repository.EmployeeRepositrory;
import ml.penkisimtai.restJersey.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepositrory employeeRepositrory;

    @Autowired
    private OfficeRepository officeRepository;

    private final List<Employee> employees = new ArrayList<>();
    private final List<Office> offices = new ArrayList<>();

    @PostConstruct
    public void init() {
        Office office = new Office("Vilnius");
        officeRepository.save(office);

        Employee employee = new Employee("Jorka", "Morka", "+37065656565", "Vilnius");
        Employee employee1 = new Employee("Gazas", "Dugnas", "+37065656565", "Vilnius");
        employee.addOffice(office);
        employee1.addOffice(office);
        employee1.setReportsTo(employee);
        employeeRepositrory.save(employee);
        employeeRepositrory.save(employee1);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepositrory.findAll();
    }


}

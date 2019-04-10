package ml.penkisimtai.restJersey.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;

    private String city;

    private String phoneNr;

    private String addressOne;

    private String addressTwo;

    private String state;

    private String country;

    private int postalCode;

    private String territory;

    @OneToMany(mappedBy = "officeCode")
    private Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setOfficeCode(this);
    }

    public void removeEmployee(Employee employee) {
        employee.setOfficeCode(null);
        this.employees.remove(employee);
    }

    public Office() {
    }

    public Office(String city) {
        this.city = city;
    }

//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public String toString() {
        return "Office{" +
                "code=" + code +
                ", city='" + city + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", addressOne='" + addressOne + '\'' +
                ", addressTwo='" + addressTwo + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                ", territory='" + territory + '\'' +
                ", employees=" + employees +
                '}';
    }
}

package ml.penkisimtai.restJersey.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String extension;

    private String email;

    private String jobTitle;

    @OneToOne
    private Office officeCode;

    @OneToOne
    private Employee reportsTo;



    public Employee(String firstName, String lastName, String mobileNumber, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {
    }

    public void addOffice(Office office) {
        this.officeCode = office;
        office.setEmployee(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Office getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Office officeCode) {
        this.officeCode = officeCode;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", officeCode=" + officeCode +
                ", reportsTo=" + reportsTo +
                '}';
    }
}

package models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee extends Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String socialSecurityNum;
    private LocalDate hiringDate;
    private String position;
    private String department;
    private int leaveDays;
    private double salary;
    private int childCount;


    public Employee() {
        super();
    }


    public Employee(String name, String email, String phoneNumber, String password, LocalDate birthdate,
                    String socialSecurityNum, LocalDate hiringDate, String position, String department,
                    int leaveDays, double salary, int childCount) {
        super(name, email, phoneNumber, password, birthdate);
        this.socialSecurityNum = socialSecurityNum;
        this.hiringDate = hiringDate;
        this.position = position;
        this.department = department;
        this.leaveDays = leaveDays;
        this.salary = salary;
        this.childCount = childCount;
    }



    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getSocialSecurityNum() {
        return socialSecurityNum;
    }
    public void setSocialSecurityNum(String socialSecurityNum) {
        this.socialSecurityNum = socialSecurityNum;
    }
    public LocalDate getHiringDate() {
        return hiringDate;
    }
    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getLeaveDays() {
        return leaveDays;
    }
    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getChildCount() {
        return childCount;
    }
    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }


}


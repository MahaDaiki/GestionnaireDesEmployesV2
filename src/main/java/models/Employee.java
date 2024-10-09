package models;

import listeners.EmployeeListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@EntityListeners(EmployeeListener.class)
public class Employee extends Users {

    @Column(unique = true, nullable = false)
    private String socialSecurityNum;
    @Column(nullable = false)
    private LocalDate hiringDate;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String department;
    private int leaveDays;
    @Column(nullable = false)
    private double salary;

    private int childCount;


    public Employee() {
        super();
    }


    public Employee(String name, String email, String phone_number, String password, LocalDate birthdate,
                    String socialSecurityNum, LocalDate hiringDate, String position, String department,
                    int leaveDays, double salary, int childCount) {
        super(name, email, phone_number, password, birthdate);
        this.socialSecurityNum = socialSecurityNum;
        this.hiringDate = hiringDate;
        this.position = position;
        this.department = department;
        this.leaveDays = leaveDays;
        this.salary = salary;
        this.childCount = childCount;
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


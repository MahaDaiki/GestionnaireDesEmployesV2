package models;


import enums.LeaveRequestStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

    @Enumerated(EnumType.STRING)
    private LeaveRequestStatus status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public LeaveRequest() {}


    public LeaveRequest(LocalDate startDate, LocalDate endDate, String reason, LeaveRequestStatus status, Employee employee) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = status;
        this.employee = employee;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public LeaveRequestStatus getStatus() {
        return status;
    }
    public void setStatus(LeaveRequestStatus status) {
        this.status = status;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



}

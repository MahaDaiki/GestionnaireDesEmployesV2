package DAO.DaoImplementation;

import DAO.DaoIntferfaces.LeaveRequestDAOInt;
import enums.LeaveRequestStatus;
import models.LeaveRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LeaveRequestDAOImpl implements LeaveRequestDAOInt {
    private EntityManager entityManager;

    public LeaveRequestDAOImpl(EntityManager entityManager) {
        this.entityManager = this.entityManager;
    }
    @Override
    public void createLeaveRequest(LeaveRequest leaveRequest) {
        leaveRequest.setStatus(LeaveRequestStatus.PENDING);
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(leaveRequest);
            transaction.commit();
        }
        catch(Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }

    }

    @Override
    public LeaveRequest findLeaveRequestById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            LeaveRequest leaveRequest = entityManager.find(LeaveRequest.class, id);
            transaction.commit();
            return leaveRequest;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<LeaveRequest> findAllLeaveRequests() {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<LeaveRequest> query = entityManager.createQuery("SELECT lr FROM LeaveRequest lr", LeaveRequest.class);
            List<LeaveRequest> leaveRequests = query.getResultList();
            transaction.commit();
            return leaveRequests;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void updateLeaveRequestStatus(Long id, LeaveRequestStatus status) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            LeaveRequest leaveRequest = entityManager.find(LeaveRequest.class, id);
            if (leaveRequest != null) {
                leaveRequest.setStatus(status);
                entityManager.merge(leaveRequest);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<LeaveRequest> findLeaveRequestsByEmployeeId(Long employeeId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            TypedQuery<LeaveRequest> query = entityManager.createQuery(
                    "SELECT lr FROM LeaveRequest lr WHERE lr.employee.id = :employeeId",
                    LeaveRequest.class);
            query.setParameter("employeeId", employeeId);

            List<LeaveRequest> leaveRequests = query.getResultList();
            transaction.commit();
            return leaveRequests;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

}

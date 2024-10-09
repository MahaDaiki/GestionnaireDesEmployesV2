package DAO.DaoImplementation;

import DAO.DaoIntferfaces.EmployeeDAOInterface;
import models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAOInterface {
    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }
    @Override
    public void createEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
        }
        catch(Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }


    }

    @Override
    public Employee findEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return Collections.emptyList();
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Long id) {

    }
}

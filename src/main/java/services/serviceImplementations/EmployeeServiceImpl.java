package services.serviceImplementations;

import DAO.DaoImplementation.EmployeeDAOImpl;
import models.Employee;
import services.serviceInterfaces.EmployeeServiceInt;

import java.util.Collections;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeServiceInt {
    private EmployeeDAOImpl EmployeeDao;
    public EmployeeServiceImpl(EmployeeDAOImpl EmployeeDao) {
        this.EmployeeDao = EmployeeDao;
    }
    @Override
    public void createEmployee(Employee employee) {
        EmployeeDao.createEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return EmployeeDao.findEmployeeById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return EmployeeDao.findAllEmployees();
    }

    @Override
    public void updateEmployee(Employee employee) {
        EmployeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        EmployeeDao.deleteEmployee(id);

    }
}

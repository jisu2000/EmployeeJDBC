package org.hit.Service;

import org.hit.Repository.EmployeeRepoImpl;
import org.hit.Repository.EmployeeRepository;
import org.hit.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository repository=new EmployeeRepoImpl();
    @Override
    public boolean addEmployee(Employee employee) {
        return repository.addEmployee(employee)!=null;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return repository.updateEmployee(employee)!=null;
    }

    @Override
    public boolean deleteEmployee(Integer employeeId) {
        return repository.deleteEmployee(employeeId)!=null;
    }

    @Override
    public Employee findbyId(Integer employeeId) {
        return repository.findById(employeeId);
    }

    @Override
    public List<Employee> findAll() {

        return repository.findall();
    }
}

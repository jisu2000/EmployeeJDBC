package org.hit.Service;

import org.hit.model.Employee;

import java.util.List;

public interface EmployeeService {
    public boolean addEmployee(Employee employee);

    public boolean updateEmployee(Employee employee);

    public boolean deleteEmployee(Integer employeeId);

    public Employee findbyId(Integer employeeId);

    public List<Employee> findAll();
}

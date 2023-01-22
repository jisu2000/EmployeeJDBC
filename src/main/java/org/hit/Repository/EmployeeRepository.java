package org.hit.Repository;

import org.hit.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public Employee deleteEmployee(Integer employeeId);

    public List<Employee> findall();

    public Employee findById(Integer employeeId);
}

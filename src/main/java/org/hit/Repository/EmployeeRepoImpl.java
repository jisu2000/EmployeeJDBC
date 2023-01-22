package org.hit.Repository;

import org.hit.model.Employee;

import java.rmi.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoImpl implements EmployeeRepository{

    private Connection connection;

    public EmployeeRepoImpl() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/hit";
            String username="root";
            String password="Jisu@2000";

            connection= DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(){

        try
        {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {

        String sql="INSERT INTO employee VALUES(?,?,?)";
        int cnt=0;

        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,employee.getEmployeeId());
            ps.setString(2,employee.getEmployeeName());
            ps.setInt(3,employee.getSalary());

            cnt=ps.executeUpdate();

            if(cnt>0)
            {
                return employee;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        int cnt=0;

        String sql="UPDATE employee SET employeename=?,salary=? WHERE employeeid=?";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,employee.getEmployeeName());
            ps.setInt(2,employee.getSalary());
            ps.setInt(3,employee.getEmployeeId());
            cnt=ps.executeUpdate();


            if(cnt>0)
            {
                return employee;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public Employee deleteEmployee(Integer employeeId) {
        int cnt=0;

        String sql="DELETE from employee WHERE employeeid=?";
        try  {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,employeeId);
            cnt=ps.executeUpdate();

            if(cnt>0)
            {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    @Override
    public List<Employee> findall() {


        String sql="SELECT * FROM employee";
        try {
            Statement st=connection.createStatement();

            ResultSet resultSet=st.executeQuery(sql);
            ArrayList<Employee>list=new ArrayList<>();
            while(resultSet.next())
            {
                list.add(new Employee(resultSet.getInt("employeeid"),resultSet.getString("employeename"),resultSet.getInt("salary")));
            }
        return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Employee findById(Integer employeeId) {

        String sql="SELECT * FROM employee WHERE employeeid=?";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,employeeId);
            ResultSet resultSet=ps.executeQuery();

            if(resultSet.next())
            {
                return new Employee(resultSet.getInt("employeeid"),resultSet.getString("employeename"),resultSet.getInt("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

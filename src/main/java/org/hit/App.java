package org.hit;

import org.hit.Service.EmployeeService;
import org.hit.Service.EmployeeServiceImpl;
import org.hit.model.Employee;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Scanner sc=new Scanner(System.in);
        int ch;
        Employee employee;
        EmployeeService service=new EmployeeServiceImpl();
        Integer id;

        do{

            System.out.println(" [1] -> for Add  || [2] -> for update || [3]-> for Delete ||  [4] -> for search || [5]-> for display ||  [6]-> for exit|| ");

            ch=sc.nextInt();

            switch (ch){
                case 1:
                    System.out.println("Enter the details : ");

                    employee=new Employee();
                    System.out.println("Enter Employee Id : ");
                    employee.setEmployeeId(sc.nextInt());
                    System.out.println("Enter Employee Name : ");
                    employee.setEmployeeName(sc.next());
                    System.out.println("Enter Employee Salary : ");
                    employee.setSalary(sc.nextInt());
                    if(service.findbyId(employee.getEmployeeId())!=null)
                    {
                        System.out.println(employee.getEmployeeId()+" is Already present :");
                        break;
                    }
                    service.addEmployee(employee);


                    break;

                case 2:
                    System.out.println("Enter Employeeid to modify : ");
                    id= sc.nextInt();
                    employee=service.findbyId(id);

                    if(employee==null)
                    {
                        System.out.println("Record not found !!");
                    }
                    else{
                        System.out.println("Existing data : ");
                        System.out.println(employee);

                        System.out.println("Enter new Details : ");
                        System.out.println("Enter Employee name : ");
                        employee.setEmployeeName(sc.next());
                        System.out.println("Enter Employee salary : ");
                        employee.setSalary(sc.nextInt());
                        service.updateEmployee(employee);

                        System.out.println("Record Updated Successfully!!");
                    }

                    break;


                case 3:
                    System.out.println("Enter the EmployeeId to Delete : ");
                    id= sc.nextInt();
                    employee=service.findbyId(id);
                    if(employee==null)
                    {
                        System.out.println("Record not found : ");
                    }

                    else{

                        System.out.println("Deleted Record");
                        System.out.println(employee);
                        service.deleteEmployee(id);

                        System.out.println("Record Deleted Successfully");
                    }
                    break;


                case 4:
                    System.out.println("Enter Employee id : ");
                    id=sc.nextInt();

                    employee=service.findbyId(id);

                    if(employee==null)
                    {
                        System.out.println("Employee not Found !! ");
                    }

                    else{
                        System.out.println(employee);
                    }
                    break;

                case 5:
                    service.findAll().forEach(System.out::println);
                    break;

                case 6:
                    break;
            }




        }while(ch!=6);

    }
}

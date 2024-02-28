import Exceptions.FileManagerException;
import Models.Department.Department;
import Models.User.Employee;
import Persistence.DataContext;

import java.io.IOException;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileManagerException, IOException {
        Department department = new Department();
        department.id = 1;
        department.name = "d1";
        department.staff = new LinkedList<>();
        Employee employee = new Employee();
        employee.id = 1;
        employee.username = "e1";
        employee.salary = 10;
        employee.department = department;
        employee.projects = new LinkedList<>();
        department.manager = employee;


        DataContext dataContext = new DataContext();
        dataContext.getDepartmentsDataAccessor().add(department);
        dataContext.getEmployeesDataAccessor().add(employee);
        Department department1 = dataContext.getDepartmentsDataAccessor().load(1);
        System.out.println(department1.name);
        System.out.println(department1.manager.username);


    }
}
package Models.Department;

import Models.User.Employee;

import java.util.List;

public class Department {
    public int id;
    public String name;
    public Employee manager;
    public List<Employee> staff;
}

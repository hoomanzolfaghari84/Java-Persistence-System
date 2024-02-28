package Models.Project;

import Models.User.Employee;

import java.util.List;

public class Project {
    public int id;
    public String name;
    public Employee Supervisor;
    public List<Employee> staff;
}

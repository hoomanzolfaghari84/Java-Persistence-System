package Models.User;

import Models.Department.Department;
import Models.Project.Project;

import java.util.List;

public class Employee extends CompanyUser{
    public int salary;
    public Department department;
    public List<Project> projects;
    public Employee manager;
}

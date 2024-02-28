import Exceptions.FileManagerException;
import Models.Department.Department;
import Models.Project.Project;
import Models.User.Employee;
import Persistence.DataContext;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//TIP some information on file class and related stream classes in :<br>
// https://www.geeksforgeeks.org/file-handling-in-java/
public class Main {

    public static void main(String[] args) throws FileManagerException, IOException {

        List<Department> departments = new LinkedList<>();
        List<Project> projects = new LinkedList<>();
        List<Employee> employees = new LinkedList<>();

        for (int i = 0; i < 2 ; i++) {
            Department department = new Department();
            department.id = i;
            department.name = "d"+i;
            department.staff = new LinkedList<>();
            departments.add(department);
        }

        for (int i = 1; i <= 6; i++) {
            Employee employee = new Employee();
            employee.id = i;
            employee.username = "e"+i;
            employee.salary = 10*i;
            employees.add(employee);
            if(i==6) continue;
            departments.getFirst().staff.add(employee);
            employee.department = departments.getFirst();
        }

        employees.get(5).department = departments.get(1);

        employees.get(1).manager = employees.get(0);
        employees.get(2).manager = employees.get(0);
        employees.get(3).manager = employees.get(0);
        employees.get(1).manager = employees.get(4);

        departments.getFirst().manager = employees.getFirst();
        departments.get(1).manager = employees.get(5);


        Project project = new Project();
        project.id = 1;
        project.name = "p1";
        project.Supervisor = employees.get(2);
        project.staff.add(employees.get(3));
        project.staff.add(employees.get(4));
        projects.add(project);

        DataContext dataContext = new DataContext();
        for (Employee employee : employees){

            dataContext.getEmployeesDataAccessor().add(employee);
        }

        for (Department department : departments){

            dataContext.getDepartmentsDataAccessor().add(department);
        }

        for (Project p : projects){
            dataContext.getProjectsDataAccessor().add(p);
        }

        Department department1 = dataContext.getDepartmentsDataAccessor().load(1);
        System.out.println(department1.name);
        System.out.println(department1.manager.username);


    }


}
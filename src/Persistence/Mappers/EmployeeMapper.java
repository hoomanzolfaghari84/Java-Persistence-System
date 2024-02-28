package Persistence.Mappers;

import Models.Department.Department;
import Models.Project.Project;
import Models.User.Employee;

import java.io.*;
import java.util.Scanner;

public class EmployeeMapper {
    public static void map(Employee employee, Scanner scanner){

        employee.id = scanner.nextInt();
        employee.username = scanner.next();
        employee.salary = scanner.nextInt();

    }

    public static void map(Employee value , FileWriter outputStream) throws IOException {


        outputStream.append(String.valueOf(value.id)).append("\n");
        outputStream.append(value.username).append("\n");
        outputStream.append(String.valueOf(value.salary)).append("\n");
        if(value.manager == null) outputStream.append("null\n");
        else outputStream.append(String.valueOf(value.manager.id)).append("\n");
        outputStream.append(String.valueOf(value.department.id)).append("\n");
        for (Project project : value.projects){
            outputStream.append(String.valueOf(project.id)).append(" ");
        }
        //outputStream.flush();
    }
}

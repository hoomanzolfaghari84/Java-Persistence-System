package Persistence.Mappers;

import Models.Department.Department;
import Models.Project.Project;
import Models.User.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DepartmentMapper {
    public static void map(Department department, Scanner scanner){

        department.id = scanner.nextInt();
        department.name = scanner.next();

    }

    public static void map(Department value , FileWriter outputStream) throws IOException {


        outputStream.append(String.valueOf(value.id)).append("\n");
        outputStream.append(value.name).append("\n");
        outputStream.append(String.valueOf(value.manager.id)).append("\n");
        for (Employee employee : value.staff){
            outputStream.append(String.valueOf(employee.id)).append(" ");
        }

        //outputStream.flush();
    }
}

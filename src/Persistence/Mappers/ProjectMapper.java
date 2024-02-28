package Persistence.Mappers;

import Models.Department.Department;
import Models.Project.Project;
import Models.User.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class ProjectMapper {
    public static void map(Project value, Scanner scanner){

        value.id = scanner.nextInt();
        value.name = scanner.next();

    }

    public static void map(Project value , FileWriter outputStream) throws IOException {

        outputStream.append(String.valueOf(value.id)).append("\n");
        outputStream.append(value.name).append("\n");
        outputStream.append(String.valueOf(value.Supervisor.id)).append("\n");
        for (Employee employee : value.staff){
            outputStream.append(String.valueOf(employee.id)).append(" ");
        }

        //outputStream.flush();
    }
}

package Persistence.DataAccessors;

import Exceptions.FileManagerException;
import Models.Department.Department;
import Models.User.Employee;
import Persistence.Mappers.DepartmentMapper;
import Persistence.Mappers.EmployeeMapper;
import Settings.FileSettings;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class DepartmentsDataAccessor extends DataAccessor<Department,Integer> {

    public static File entriesDirectory = FileSettings.departmentsDirectory;;
    public DepartmentsDataAccessor() throws FileManagerException {
        super();

        if(!entriesDirectory.exists() && !entriesDirectory.mkdirs()) throw new FileManagerException("creating model directory "+ entriesDirectory.getName() + " was unsuccessful");
    }

    @Override
    public void add(Department department) throws IOException, FileManagerException {
        File entryFile = new File(entriesDirectory + "/" + department.id +".department");
        if(!entryFile.exists()) {
            if(!entryFile.createNewFile()) throw new FileManagerException("could not create");
        }
        else throw new FileManagerException("already exists");

        try (FileWriter fileWriter = new FileWriter(entryFile)) {
            DepartmentMapper.map(department,fileWriter);
            fileWriter.flush();
        }


    }

    @Override
    public void delete(Department department) {

    }

    @Override
    public Department load(Integer integer) throws FileNotFoundException {

        File entryFile = new File(entriesDirectory + "/" + integer.toString() +".department");
        Scanner scanner = new Scanner(entryFile);
        Department department = new Department();

        DepartmentMapper.map(department,scanner);

        File managerEntry = new File(EmployeesDataAccessor.entriesDirectory + "/" + scanner.nextInt() + ".employee");
        Scanner managerScanner = new Scanner(managerEntry);
        Employee manager = new Employee();
        EmployeeMapper.map(manager,managerScanner);

        department.manager = manager;
        manager.department = department;
        managerScanner.close();

        department.staff = new LinkedList<>();
        while (scanner.hasNext()){
            File staffEntry = new File(EmployeesDataAccessor.entriesDirectory + String.valueOf(scanner.nextInt()) + ".employee");
            Scanner staffScanner = new Scanner(staffEntry);
            Employee staff = new Employee();
            EmployeeMapper.map(staff,staffScanner);

            department.staff.add(staff);
            staff.department = department;
            staffScanner.close();

        }

        scanner.close();

        return department;
    }


    @Override
    public Department update(Department department) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public <T> boolean any(Predicate<T> predicate) {
        return false;
    }

    @Override
    public <T> List<Department> where(Predicate<T> predicate) {
        return null;
    }

    @Override
    public List<Integer> AllExistingKeys() {
        List<Integer> keys = new LinkedList<>();
        for (File entry : Objects.requireNonNull(entriesDirectory.listFiles(File::isFile))){
            keys.add(Integer.parseInt(entry.getName().split("\\.")[0]));
        }
        return keys;
    }
}
